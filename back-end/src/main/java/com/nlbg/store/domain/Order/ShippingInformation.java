package com.nlbg.store.domain.Order;

import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.User.Admin;
import com.nlbg.store.domain.User.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ShippingInformation extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private boolean localPickup;
    @NotNull
    private int shippingStatus;
    @NotNull
    private String shippingAddress;

    @OneToOne
    @JoinColumn(name = "order_ID", referencedColumnName = "id")
    private Order parentOrder;

    public ShippingInformation(boolean localPickup, Customer customer, Order order) {
        this.localPickup = localPickup;
        this.shippingAddress = customer.getShippingAddress();
        this.parentOrder = order;
        this.shippingStatus = 0;
    }

    public ShippingInformation(boolean localPickup, Admin admin, Order order) {
        this.localPickup = localPickup;
        this.shippingAddress = admin.getShippingAddress();
        this.parentOrder = order;
        this.shippingStatus = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLocalPickup() {
        return localPickup;
    }

    public void setLocalPickup(boolean localPickup) {
        this.localPickup = localPickup;
    }

    public int getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(int shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Order getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(Order parentOrder) {
        this.parentOrder = parentOrder;
    }
}
