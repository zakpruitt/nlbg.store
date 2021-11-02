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

@Data
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
}
