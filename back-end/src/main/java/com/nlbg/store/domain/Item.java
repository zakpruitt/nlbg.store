package com.nlbg.store.domain;

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
    private Long itemId;

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
    @ManyToOne
    @JoinColumn(name = "column_id")
    private Category category;

    @PostConstruct
    private void setQuantities() {
        this.quantitySold = 0;
        this.quantityBought = 0;
    }
}
