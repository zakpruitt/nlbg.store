package com.nlbg.store.domain.Order;

import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Photo.Photo;
import com.nlbg.store.domain.User.Customer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int orderStatus;
    @Lob
    private String comments;
    private String orderGroupId;
    private String orderType;
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_information_ID", referencedColumnName = "id")
    private ShippingInformation shippingInformation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    Set<Photo> sellOrderPhotos = new HashSet<>();

    public Order(Item item, Customer customer, int orderStatus, String orderType, String comments, Double total) {
        this.item = item;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.comments = comments;
        this.orderType = orderType;
        this.total = total;
    }

    public Order(Item item, Customer customer, int orderStatus, String orderType, Double total) {
        this.item = item;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.total = total;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getOrderGroupId() {
        return orderGroupId;
    }

    public void setOrderGroupId(String orderGroupId) {
        this.orderGroupId = orderGroupId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public Set<Photo> getSellOrderPhotos() {
        return sellOrderPhotos;
    }

    public void setSellOrderPhotos(Set<Photo> sellOrderPhotos) {
        this.sellOrderPhotos = sellOrderPhotos;
    }

    public String generateOrderGroupID() {
        this.orderGroupId = UUID.randomUUID().toString();
        return this.orderGroupId;
    }
}
