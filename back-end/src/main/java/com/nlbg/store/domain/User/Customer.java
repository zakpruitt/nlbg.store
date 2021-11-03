package com.nlbg.store.domain.User;

import com.nlbg.store.domain.Item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer extends User {
//    @OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Order> orders;
//    @OneToMany(mappedBy = "customer_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Raffle> raffles;
}
