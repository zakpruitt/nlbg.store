package com.nlbg.store.domain.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Photo.Photo;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Item extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Item Name is required.")
    private String itemName;
    @NotNull
    private double itemDesiredValue;
    @Nullable
    private double itemAverageValue;
    @NotNull
    private int quantitySold;
    @NotNull
    private int quantityBought;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Nullable
    @JsonIgnore
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Nullable
    @JsonIgnore
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RaffleDetail> associatedRaffles;

    @ManyToMany
    @JoinTable(
            name = "item_photo",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    Set<Photo> photos;

    public Item(String itemName, double itemDesiredValue, Category category) {
        this.itemName = itemName;
        this.itemDesiredValue = itemDesiredValue;
        this.category = category;
    }

    public Item() {
        this.quantitySold = 0;
        this.quantityBought = 0;
        this.itemAverageValue = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemDesiredValue() {
        return itemDesiredValue;
    }

    public void setItemDesiredValue(double itemDesiredValue) {
        this.itemDesiredValue = itemDesiredValue;
    }

    public double getItemAverageValue() {
        return itemAverageValue;
    }

    public void setItemAverageValue(double itemAverageValue) {
        this.itemAverageValue = itemAverageValue;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Nullable
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(@Nullable Set<Order> orders) {
        this.orders = orders;
    }

    @Nullable
    public Set<RaffleDetail> getAssociatedRaffles() {
        return associatedRaffles;
    }

    public void setAssociatedRaffles(@Nullable Set<RaffleDetail> associatedRaffles) {
        this.associatedRaffles = associatedRaffles;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }
}
