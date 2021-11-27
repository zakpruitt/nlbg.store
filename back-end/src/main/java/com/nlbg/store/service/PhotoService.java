package com.nlbg.store.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class PhotoService {

    //TODO: generate new api key and secret.
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dxoa7bbix",
            "api_key", "161649288458746",
            "api_secret", "eujBGLpb3B30KuJDbUcVOWAp3oA"));

    public void uploadImage(String imageURL, String publicId) throws IOException {
        cloudinary.uploader().upload(new File(imageURL), ObjectUtils.asMap("public_id", "olympic_flag"));
    }

    public String retrieveImageURL(String publicId) throws Exception {
        Map result = cloudinary.api().resource("olympic_flag", ObjectUtils.emptyMap());
        return result.get("secure_url").toString();
    }
}
