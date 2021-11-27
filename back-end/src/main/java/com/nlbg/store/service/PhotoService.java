package com.nlbg.store.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class PhotoService {

    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dxoa7bbix",
            "api_key", "161649288458746",
            "api_secret", "eujBGLpb3B30KuJDbUcVOWAp3oA"));

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("here");
//            cloudinary.uploader().upload(new File("C:/Program Files (x86)/World of Warcraft/_classic_era_/Screenshots/awesome.jpg"),
//                    ObjectUtils.asMap("public_id", "olympic_flag"));
        };
    }
}
