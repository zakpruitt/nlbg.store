package com.nlbg.store.controller;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.PurchaseOrderExport;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.repository.RaffleRepository;
import com.nlbg.store.service.ItemService;
import com.nlbg.store.service.OrderService;
import com.nlbg.store.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderService orderService;
    @Autowired
    PhotoService photoService;
    @Autowired
    RaffleRepository raffleRepository;
    @Autowired
    ItemService itemService;

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

    @GetMapping("/raffle-mngt")
    public String renderCreateRaffle(Principal principal) {
        if (!principal.getName().equals("zakpruitt5@gmail.com")) return "redirect:/";
        return "admin_raffle";
    }

    @PostMapping("/create-raffle")
    @ResponseBody
    public String createAdminRaffle() {
        Item predatorAirRush = itemService.getItemByName("Predator Air Rush");
        Raffle raffle = new Raffle(
                LocalDate.of(2021, 11, 5),
                LocalDate.of(2022, 11, 6));
        RaffleDetail raffleDetail = new RaffleDetail(20, 20, predatorAirRush, raffle);
        raffle.setRaffleDetail(raffleDetail);
        raffleRepository.save(raffle);
        return raffle.getURL();
    }
}
