package com.nlbg.store.controller;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import com.nlbg.store.service.CustomerService;
import com.nlbg.store.service.ItemService;
import com.nlbg.store.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
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

    @GetMapping("/sell-order")
    public String renderCreateSellOrder(Principal principal, Model model) {
        Customer customer = customerService.getCustomerByEmail(principal.getName());
        List<Item> items = itemService.getAllItems();

        model.addAttribute("customer", customer);
        model.addAttribute("items", items);
        return "create_sell_order";
    }
}
