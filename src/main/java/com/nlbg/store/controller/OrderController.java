package com.nlbg.store.controller;

import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.PaypalOrderForm;
import com.nlbg.store.domain.Order.SellOrderForm;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.service.CustomerService;
import com.nlbg.store.service.ItemService;
import com.nlbg.store.service.OrderService;
import com.nlbg.store.service.ShoppingCartService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/")
    public String renderOrders(Principal principal, Model model) {
        Customer customer = customerService.getCustomerByEmail(principal.getName());
        List<Order> orders = orderService.getAllByCustomer(customer);
        System.out.println(orders);
        model.addAttribute("orders", orders);
        return "order_display";
    }

    @GetMapping("/sell-order")
    public String renderCreateSellOrderForm(Principal principal, Model model) {
        Customer customer = customerService.getCustomerByEmail(principal.getName());
        Hashtable<String, Double> itemPrice = itemService.getAllItemPrice();
        SellOrderForm sellOrderForm = new SellOrderForm();

        model.addAttribute("customer", customer);
        model.addAttribute("items", itemPrice);
        model.addAttribute("sellOrderForm", sellOrderForm);
        model.addAttribute("shoppingCartSize", shoppingCartService.getCartSize());
        return "create_sell_order";
    }

    @PostMapping("/sell-order")
    public String createSellOrder(@ModelAttribute("sellOrderForm") SellOrderForm sellOrderForm, Principal principal) {
        try {
            Customer customer = customerService.getCustomerByEmail(principal.getName());
            orderService.createSellOrder(sellOrderForm, customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/pay")
    public String facilitatePayment(@ModelAttribute("paypalOrderForm") PaypalOrderForm paypalOrderForm) {
        try {
            Payment payment = orderService.createPayment(
                    paypalOrderForm,
                    "http://localhost:8080/orders/cancel",
                    "http://localhost:8080/orders/success"
            );
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException | IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/cancel")
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping("/success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = orderService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}
