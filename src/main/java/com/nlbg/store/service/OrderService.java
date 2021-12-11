package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.PaypalOrderForm;
import com.nlbg.store.domain.Order.SellOrderForm;
import com.nlbg.store.domain.Order.ShippingInformation;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.OrderRepository;
import com.nlbg.store.repository.ShippingInformationRepository;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShippingInformationRepository shippingInformationRepository;
    @Autowired
    private APIContext apiContext;
    @Autowired
    private ItemService itemService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShippingInformationService shippingInformationService;

    public List<Order> getAllSellOrders() {
        return orderRepository.findAllSellOrders();
    }

    public List<Order> getAllPurchaseOrders() {
        return orderRepository.findAllPurchaseOrders();
    }

    public List<Order> getAllByCustomer(Customer customer) {
        return orderRepository.findAllByCustomerId(customer.getId());
    }

    public void createSellOrder(SellOrderForm sellOrderForm, Customer customer) throws IOException {
        Item item = itemService.getItemByName(sellOrderForm.getItemName());
        if (item == null) {
            // TODO: Handle new category.
            //item = new Item(sellOrderForm.getItemName(), sellOrderForm.getItemPrice(), );
        }

        Order order = new Order(item, customer, 0, "Sell", sellOrderForm.getComments(), sellOrderForm.getItemPrice());
        // TODO: Handle local pickup.
        ShippingInformation shippingInformation = new ShippingInformation(
                "3608 Quarry Ridge Dr.",
                "United States",
                "Evansville",
                "IN",
                "47720",
                sellOrderForm.getShippingAddress(),
                sellOrderForm.getShippingCountry(),
                sellOrderForm.getShippingCity(),
                sellOrderForm.getShippingState(),
                sellOrderForm.getShippingZip(),
                order
        );
        String labelURL = shippingInformationService.getShippingLabelToURL(sellOrderForm);
        shippingInformation.setShippingLabelURL(labelURL);
        order.setShippingInformation(shippingInformation);

        orderRepository.save(order);
        for (MultipartFile file : sellOrderForm.getPhotos()) {
            order.getSellOrderPhotos().add(photoService.uploadImage(
                    file,
                    UUID.randomUUID().toString(),
                    order,
                    "secondary"
            ));
        }
        orderRepository.save(order);
    }

    public Payment createPayment(PaypalOrderForm paypalOrderForm, String cancelUrl, String successUrl) throws PayPalRESTException, IOException {
        Customer customer = customerService.getCustomerByEmail(paypalOrderForm.getEmail());

        Amount amount = generateAmount(paypalOrderForm);
        Transaction transaction = new Transaction();

        transaction.setItemList(generateItemList(paypalOrderForm, customer));
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");

        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }

    private Amount generateAmount(PaypalOrderForm paypalOrderForm) {
        Amount amount = new Amount();
        amount.setCurrency("USD");
        double total = new BigDecimal(paypalOrderForm.getPrice()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));
        return amount;
    }

    private ItemList generateItemList(PaypalOrderForm paypalOrderForm, Customer customer) throws IOException {
        ItemList itemList = new ItemList();
        List<com.paypal.api.payments.Item> items = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        for (Map.Entry<Item, Integer> kvp : shoppingCartService.getProducts().entrySet()) {
            Item currentItem = kvp.getKey();
            com.paypal.api.payments.Item item = generatePaypalItem(currentItem, kvp.getValue());
            items.add(item);

            // purchase order (customer buying)
            for (int i = 0; i < kvp.getValue(); i++) {
                Order order = new Order(currentItem, customer, 4, "Purchase", paypalOrderForm.getPrice());
                ShippingInformation shippingInformation = new ShippingInformation(
                        paypalOrderForm.getShippingAddress(),
                        paypalOrderForm.getShippingCountry(),
                        paypalOrderForm.getShippingCity(),
                        paypalOrderForm.getShippingState(),
                        paypalOrderForm.getShippingZip(),
                        "3608 Quarry Ridge Dr.",
                        "United States",
                        "Evansville",
                        "IN",
                        "47720",
                        order
                );
                currentItem.setQuantitySold(currentItem.getQuantitySold() + 1);
                order.setShippingInformation(shippingInformation);
                orders.add(order);
            }
        }
        String groupID = orders.get(0).generateOrderGroupID();
        String labelURL = shippingInformationService.getShippingLabelFromURL(paypalOrderForm);
        for (Order order : orders) {
            order.setOrderGroupId(groupID);
            order.getShippingInformation().setShippingLabelURL(labelURL);
        }
        orderRepository.saveAll(orders);
        itemList.setItems(items);
        return itemList;
    }

    private com.paypal.api.payments.Item generatePaypalItem(Item item, Integer quantity) {
        com.paypal.api.payments.Item paypalItem = new com.paypal.api.payments.Item();
        paypalItem.setCurrency("USD");
        paypalItem.setName(item.getItemName());
        paypalItem.setPrice(item.getItemDesiredValue().toString());
        paypalItem.setQuantity(quantity.toString());
        return paypalItem;
    }
}
