package com.nlbg.store.domain.Raffle;


import com.nlbg.store.domain.User.Customer;

import javax.persistence.*;
import java.util.Objects;

public class RaffleCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "raffle_id", referencedColumnName = "id")
    private Raffle raffle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public RaffleCustomer(Raffle raffle, Customer customer, int position) {
        this.raffle = raffle;
        this.customer = customer;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Raffle getRaffle() {
        return raffle;
    }

    public void setRaffle(Raffle raffle) {
        this.raffle = raffle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RaffleCustomer)) return false;
        RaffleCustomer that = (RaffleCustomer) o;
        return getPosition() == that.getPosition() && getId().equals(that.getId()) && getRaffle().equals(that.getRaffle()) && getCustomer().equals(that.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosition(), getRaffle(), getCustomer());
    }
}
