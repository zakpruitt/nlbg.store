package com.nlbg.store.domain.User;

import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Customer extends User {
        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Order> orders;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private Set<Raffle> wonRaffles;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private Set<RaffleCustomer> raffleCustomers;
}
