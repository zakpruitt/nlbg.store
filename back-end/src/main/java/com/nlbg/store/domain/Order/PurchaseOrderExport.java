package com.nlbg.store.domain.Order;

import com.nlbg.store.domain.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderExport {

    private List<String> items = new ArrayList<>();
    private Double total;
    private String shippingLabelURL;
    private Integer orderStatus;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getShippingLabelURL() {
        return shippingLabelURL;
    }

    public void setShippingLabelURL(String shippingLabelURL) {
        this.shippingLabelURL = shippingLabelURL;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
