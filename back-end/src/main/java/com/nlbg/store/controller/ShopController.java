package com.nlbg.store.controller;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Item.ShoppingCartInput;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Photo.Photo;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.repository.OrderRepository;
import com.nlbg.store.service.ItemService;
import com.nlbg.store.service.PhotoService;
import com.nlbg.store.service.ShoppingCartService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.HashMap;

@Controller
public class ShopController {

    @Autowired
    ItemService itemService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PhotoService photoService;

    @GetMapping("/")
    public String renderShop(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("email", principal.getName());
        } else {
            model.addAttribute("email", "NONE");
        }
        return "shop";
    }

    @GetMapping("/{itemId}")
    public String renderProductShowcase(@PathVariable Long itemId, Model model) {
        try {
            Item item = itemService.getItemById(itemId);
            model.addAttribute("item", item);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "item";
    }

    @GetMapping("/checkout")
    public void renderCheckout() {

    }

    @PostMapping
    public String addToCart(@ModelAttribute("shoppingCartInput") ShoppingCartInput shoppingCartInput) {
        Item item = itemService.getItemByName(shoppingCartInput.getItemName());
        shoppingCartService.addProduct(item, shoppingCartInput.getQuantity());
        return "redirect:/";
    }

//    @PostMapping
//    public void removeFromCart(@ModelAttribute("shoppingCartInput") ShoppingCartInput shoppingCartInput) {
//
//    }



    // *************************************************************************************

    @GetMapping("/test")
    public String renderShopa(Principal principal, Model model) {
        return "test1";
    }

    @GetMapping("/photo/{orderId}")
    public String renderPhotos(@PathVariable Long orderId, Model model) {
        try {
            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new NotFoundException("dang"));
            for (Photo photo : order.getSellOrderPhotos()) {
                System.out.println(photo.getSecureURL());
            }
            model.addAttribute("photos", order.getSellOrderPhotos());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return "test";
    }

    @GetMapping("/test/{tag}")
    @ResponseBody
    public String downloadZip(@PathVariable String tag) {
        String a = "";
        try {
            a = photoService.downloadImagesAsZip(tag);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return a;
    }
}
