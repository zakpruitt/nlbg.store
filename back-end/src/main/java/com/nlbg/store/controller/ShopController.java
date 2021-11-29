package com.nlbg.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ShopController {

    @GetMapping("/")
    public String renderShop(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("email", principal.getName());
        } else {
            model.addAttribute("email", "NONE");
        }
        return "shop";
    }
}
