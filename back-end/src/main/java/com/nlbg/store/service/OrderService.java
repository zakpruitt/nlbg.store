package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
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

    public void createSellOrder(SellOrderForm sellOrderForm, Customer customer) throws IOException {
        Item item = itemService.getItemByName(sellOrderForm.getItemName());
        if (item == null) {
            // TODO: Handle new category.
            //item = new Item(sellOrderForm.getItemName(), sellOrderForm.getItemPrice(), );
        }

        Order order = new Order(item, customer, 0);
        // TODO: Handle local pickup.
        ShippingInformation shippingInformation = new ShippingInformation(
                true,
                "3608 Quarry Ridge Dr., Evansville, IN 47720",
                sellOrderForm.getShippingAddress(),
                order
        );
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

    public Payment createPayment(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl) throws PayPalRESTException {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();

        ItemList itemList = new ItemList();
        List<com.paypal.api.payments.Item> a = new ArrayList<>();

        com.paypal.api.payments.Item i = new com.paypal.api.payments.Item();
        i.setCurrency("USD");
        i.setName("Predator Air Rush");
        i.setPrice("10");
        i.setQuantity("1");

        a.add(i);
        itemList.setItems(a);

        transaction.setItemList(itemList);
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

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

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
}
