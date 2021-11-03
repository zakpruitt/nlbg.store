package com.nlbg.store.domain.Order;

import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.User.Customer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Order extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int orderStatus;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date startDate;
    @Nullable
    private Date endDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @NotNull
    @OneToOne
    @JoinColumn(name = "shipping_information_ID", referencedColumnName = "id")
    private ShippingInformation shippingInformation;

    public Order(Item item, Customer customer, ShippingInformation shippingInformation) {
        this.item = item;
        this.customer = customer;
        this.shippingInformation = shippingInformation;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Nullable
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@Nullable Date endDate) {
        this.endDate = endDate;
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
}
