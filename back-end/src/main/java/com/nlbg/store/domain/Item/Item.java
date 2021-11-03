package com.nlbg.store.domain.Item;

import com.nlbg.store.domain.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
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

    public Item(String itemName, double itemDesiredValue, Category category) {
        this.itemName = itemName;
        this.itemDesiredValue = itemDesiredValue;
        this.category = category;
    }

    @PostConstruct
    private void setQuantities() {
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
}
