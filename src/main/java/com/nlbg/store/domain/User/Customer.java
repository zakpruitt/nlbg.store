package com.nlbg.store.domain.User;

import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.Set;

@Entity
public class Customer extends User {
        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Order> orders;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private Set<Raffle> wonRaffles;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private Set<RaffleCustomer> raffleCustomers;

        public Customer(String firstName, String lastName, String password, String email, String phoneNumber, String shippingAddress, String shippingCity, String shippingState, String shippingZip) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.password = password;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.shippingAddress = shippingAddress;
                this.shippingCity = shippingCity;
                this.shippingState = shippingState;
                this.shippingZip = shippingZip;
                enabled = false;
                locked = false;
        }

        public Customer() {
        }

        public Set<Order> getOrders() {
                return orders;
        }

        public void setOrders(Set<Order> orders) {
                this.orders = orders;
        }

        public Set<Raffle> getWonRaffles() {
                return wonRaffles;
        }

        public void setWonRaffles(Set<Raffle> wonRaffles) {
                this.wonRaffles = wonRaffles;
        }

        public Set<RaffleCustomer> getRaffleCustomers() {
                return raffleCustomers;
        }

        public void setRaffleCustomers(Set<RaffleCustomer> raffleCustomers) {
                this.raffleCustomers = raffleCustomers;
        }
}
