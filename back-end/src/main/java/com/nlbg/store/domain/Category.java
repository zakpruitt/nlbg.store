package com.nlbg.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @NotEmpty(message = "Item Name is required.")
    private String categoryName;
    @NotNull
    private double categoryDescription;
    @Nullable
    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private Set items = new HashSet<>();
}
