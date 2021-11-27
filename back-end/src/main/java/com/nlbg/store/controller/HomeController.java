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

    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dxoa7bbix",
            "api_key", "161649288458746",
            "api_secret", "eujBGLpb3B30KuJDbUcVOWAp3oA"));

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping
    @RequestMapping("/yo")
    public String hello() throws Exception {
        Map result = cloudinary.api().resource("olympic_flag", ObjectUtils.emptyMap());
        return result.get("secure_url").toString();
    }
}
