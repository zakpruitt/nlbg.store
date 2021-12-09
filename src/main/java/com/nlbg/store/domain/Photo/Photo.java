package com.nlbg.store.domain.Photo;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String secureURL;
    private String photoType;

    @ManyToMany(mappedBy = "photos")
    Set<Item> items = new HashSet<>();
    @ManyToMany(mappedBy = "sellOrderPhotos")
    Set<Order> sellOrders = new HashSet<>();

    public Photo() {

    }

    public Photo(String secureURL, String photoType, Item item) {
        this.secureURL = secureURL;
        this.photoType = photoType;
        items.add(item);
    }

    public Photo(String secureURL, String photoType, Order sellOrder) {
        this.secureURL = secureURL;
        this.photoType = photoType;
        sellOrders.add(sellOrder);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecureURL() {
        return secureURL;
    }

    public void setSecureURL(String secureURL) {
        this.secureURL = secureURL;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Order> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(Set<Order> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
