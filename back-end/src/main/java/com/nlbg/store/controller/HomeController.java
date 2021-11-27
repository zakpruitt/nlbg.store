package com.nlbg.store.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Map;
import java.util.Set;

@RestController
public class HomeController {

    @GetMapping
    public String home() {
        return "home";
    }
}
