package com.nlbg.store.controller;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.SellOrderForm;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import com.nlbg.store.service.CustomerService;
import com.nlbg.store.service.ItemService;
import com.nlbg.store.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    @GetMapping("/sell-order")
    public String renderCreateSellOrder(Principal principal, Model model) {
        Customer customer = customerService.getCustomerByEmail(principal.getName());
        Hashtable<String, Double> itemPrice = itemService.getAllItemPrice();
        SellOrderForm sellOrderForm = new SellOrderForm();

        model.addAttribute("customer", customer);
        model.addAttribute("items", itemPrice);
        model.addAttribute("sellOrderForm", sellOrderForm);
        return "create_sell_order";
    }

    @PostMapping("/sell-order")
    @ResponseBody
    public String createSellOrder(@ModelAttribute("sellOrderForm") SellOrderForm sellOrderForm) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sellOrderForm.getFirstName());
        stringBuilder.append(sellOrderForm.getLastName());
        stringBuilder.append(sellOrderForm.getEmail());
        stringBuilder.append(sellOrderForm.getPhoneNumber());
        stringBuilder.append(sellOrderForm.getItemName());
        stringBuilder.append(sellOrderForm.getItemPrice().toString());
        stringBuilder.append(sellOrderForm.getComments());
        for (MultipartFile file : sellOrderForm.getPhotos()) {
            stringBuilder.append("\n" + file.getOriginalFilename() + "\n");
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
