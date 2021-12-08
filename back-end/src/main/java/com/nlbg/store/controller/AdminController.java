package com.nlbg.store.controller;

import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.PurchaseOrderExport;
import com.nlbg.store.domain.Photo.Photo;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.service.CustomerService;
import com.nlbg.store.service.OrderService;
import com.nlbg.store.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    PhotoService photoService;

    @GetMapping("/sell-orders")
    public String renderAdminSellOrders(Principal principal, Model model) {
        if (!principal.getName().equals("zakpruitt5@gmail.com")) return "redirect:/";
        List<Order> sellOrders = orderService.getAllSellOrders();
        HashMap<Order, String> orderZip = new HashMap<>();
        sellOrders.forEach(order -> {
                    try {
                        orderZip.put(
                                order,
                                photoService.downloadImagesAsZip(order.getId().toString()
                                ));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
        );
        model.addAttribute("sellOrders", orderZip);
        return "admin_sell_order";
    }

    @GetMapping("/purchase-orders")
    public String renderAdminPurchaseOrders(Principal principal, Model model) {
        if (!principal.getName().equals("zakpruitt5@gmail.com")) return "redirect:/";
        List<Order> purchaseOrders = orderService.getAllPurchaseOrders();
        HashMap<String, PurchaseOrderExport> poeMap = new HashMap<>();
        for (Order order : purchaseOrders) {
            if (!poeMap.containsKey(order.getOrderGroupId())) {
                // hasnt been seen yet
                PurchaseOrderExport purchaseOrderExport = new PurchaseOrderExport();
                purchaseOrderExport.setTotal(order.getTotal());
                purchaseOrderExport.setShippingLabelURL(order.getShippingInformation().getShippingLabelURL());
                purchaseOrderExport.setOrderStatus(order.getOrderStatus());
                purchaseOrderExport.getItems().add(order.getItem().getItemName());
                poeMap.put(order.getOrderGroupId(), purchaseOrderExport);
            } else {
                // has been seen, so just add item
                poeMap.get(order.getOrderGroupId())
                        .getItems()
                        .add(order.getItem().getItemName());
            }
        }
        model.addAttribute("purchaseOrders", poeMap);
        return "admin_purchase_order";
    }
}
