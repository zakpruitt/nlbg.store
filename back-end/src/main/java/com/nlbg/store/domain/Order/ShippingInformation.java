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

    private String shippingToAddress;
    private String shippingToCountry;
    private String shippingToCity;
    private String shippingToState;
    private String shippingToZip;
    private String shippingFromAddress;
    private String shippingFromCountry;
    private String shippingFromCity;
    private String shippingFromState;
    private String shippingFromZip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID", referencedColumnName = "id")
    private Order parentOrder;

    public ShippingInformation(String shippingToAddress, String shippingToCountry, String shippingToCity, String shippingToState, String shippingToZip, String shippingFromAddress, String shippingFromCountry, String shippingFromCity, String shippingFromState, String shippingFromZip, Order parentOrder) {
        this.shippingToAddress = shippingToAddress;
        this.shippingToCountry = shippingToCountry;
        this.shippingToCity = shippingToCity;
        this.shippingToState = shippingToState;
        this.shippingToZip = shippingToZip;
        this.shippingFromAddress = shippingFromAddress;
        this.shippingFromCountry = shippingFromCountry;
        this.shippingFromCity = shippingFromCity;
        this.shippingFromState = shippingFromState;
        this.shippingFromZip = shippingFromZip;
        this.parentOrder = parentOrder;
    }

    public ShippingInformation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingToAddress() {
        return shippingToAddress;
    }

    public void setShippingToAddress(String shippingToAddress) {
        this.shippingToAddress = shippingToAddress;
    }

    public String getShippingToCountry() {
        return shippingToCountry;
    }

    public void setShippingToCountry(String shippingToCountry) {
        this.shippingToCountry = shippingToCountry;
    }

    public String getShippingToCity() {
        return shippingToCity;
    }

    public void setShippingToCity(String shippingToCity) {
        this.shippingToCity = shippingToCity;
    }

    public String getShippingToState() {
        return shippingToState;
    }

    public void setShippingToState(String shippingToState) {
        this.shippingToState = shippingToState;
    }

    public String getShippingToZip() {
        return shippingToZip;
    }

    public void setShippingToZip(String shippingToZip) {
        this.shippingToZip = shippingToZip;
    }

    public String getShippingFromAddress() {
        return shippingFromAddress;
    }

    public void setShippingFromAddress(String shippingFromAddress) {
        this.shippingFromAddress = shippingFromAddress;
    }

    public String getShippingFromCountry() {
        return shippingFromCountry;
    }

    public void setShippingFromCountry(String shippingFromCountry) {
        this.shippingFromCountry = shippingFromCountry;
    }

    public String getShippingFromCity() {
        return shippingFromCity;
    }

    public void setShippingFromCity(String shippingFromCity) {
        this.shippingFromCity = shippingFromCity;
    }

    public String getShippingFromState() {
        return shippingFromState;
    }

    public void setShippingFromState(String shippingFromState) {
        this.shippingFromState = shippingFromState;
    }

    public String getShippingFromZip() {
        return shippingFromZip;
    }

    public void setShippingFromZip(String shippingFromZip) {
        this.shippingFromZip = shippingFromZip;
    }

    public Order getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(Order parentOrder) {
        this.parentOrder = parentOrder;
    }
}
