package com.nlbg.store.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Photo.Photo;
import com.nlbg.store.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    //TODO: generate new api key and secret.
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dxoa7bbix",
            "api_key", "161649288458746",
            "api_secret", "eujBGLpb3B30KuJDbUcVOWAp3oA"));

    public Photo uploadItemImage(String imageURL, String publicId, Item item, String photoType) throws IOException {
        Map result = cloudinary.uploader().upload(new File(imageURL), ObjectUtils.asMap("public_id", publicId));
        Photo itemPhoto = new Photo(
                result.get("secure_url").toString(),
                photoType,
                item
        );
        return photoRepository.save(itemPhoto);
    }

    public Photo uploadOrderImage(String imageURL, String publicId, Order order, String photoType) throws IOException {
        Map result = cloudinary.uploader().upload(new File(imageURL), ObjectUtils.asMap("public_id", publicId));
        Photo sellOrderPhoto = new Photo(
                result.get("secure_url").toString(),
                photoType,
                order
        );
        return photoRepository.save(sellOrderPhoto);
    }

    public Photo a() {
        cloudinary.downloadMulti()
    }
}