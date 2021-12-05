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

    private boolean localPickup;
    private int shippingStatus;
    private String shippingTo;
    private String shippingFrom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID", referencedColumnName = "id")
    private Order parentOrder;

    public ShippingInformation(boolean localPickup, String shippingTo, String shippingFrom, Order order) {
        this.localPickup = localPickup;
        this.shippingFrom = shippingFrom;
        this.shippingTo = shippingTo;
        this.parentOrder = order;
        this.shippingStatus = 0;
    }

    public ShippingInformation() {
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

    public String getShippingTo() {
        return shippingTo;
    }

    public void setShippingTo(String shippingTo) {
        this.shippingTo = shippingTo;
    }

    public String getShippingFrom() {
        return shippingFrom;
    }

    public void setShippingFrom(String shippingFrom) {
        this.shippingFrom = shippingFrom;
    }

    public Order getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(Order parentOrder) {
        this.parentOrder = parentOrder;
    }
}
