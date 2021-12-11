package com.nlbg.store.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Photo.Photo;
import com.nlbg.store.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
public class PhotoService {

    //TODO: generate new api key and secret.
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dxoa7bbix",
            "api_key", "161649288458746",
            "api_secret", ""
    ));
    @Autowired
    PhotoRepository photoRepository;

    public Photo uploadImage(String url, String publicId, Item item, String photoType) throws IOException {
        Map result = cloudinary.uploader().upload(new File(url), ObjectUtils.asMap(
                "public_id", publicId,
                "tags", item.getId().toString()
        ));
        Photo itemPhoto = new Photo(
                result.get("secure_url").toString(),
                photoType,
                item
        );
        return photoRepository.save(itemPhoto);
    }

    public Photo uploadImage(MultipartFile file, String publicId, Order order, String photoType) throws IOException {
        Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "public_id", publicId,
                "tags", order.getId().toString()));
        Photo sellOrderPhoto = new Photo(
                result.get("secure_url").toString(),
                photoType,
                order
        );
        return photoRepository.save(sellOrderPhoto);
    }

    public String downloadImagesAsZip(String tag) throws UnsupportedEncodingException {
        String url = cloudinary.downloadZip(ObjectUtils.asMap(
                "tags", tag,
                "resource_type", "image")
        );
        int splitIndex = url.indexOf('?');
        int timestampIndex = url.length() - 10;
        int endIndex = url.length() - 16;
        String timestamp = "?timestamp=" + url.substring(timestampIndex) + "&";
        url = url.substring(0, splitIndex) + timestamp + url.substring(splitIndex + 1, endIndex);
        return url;
    }
}