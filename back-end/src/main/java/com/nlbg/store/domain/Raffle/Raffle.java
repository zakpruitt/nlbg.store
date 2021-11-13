package com.nlbg.store.domain.Raffle;

import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.User.Customer;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Raffle extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private int winningSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winning_customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "raffle", cascade = CascadeType.ALL)
    private Set<RaffleCustomer> raffleCustomers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raffle_details_id", referencedColumnName = "id")
    private RaffleDetail raffleDetail;

    public Raffle(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Raffle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getWinningSlot() {
        return winningSlot;
    }

    public void setWinningSlot(int winningSlot) {
        this.winningSlot = winningSlot;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<RaffleCustomer> getRaffleCustomers() {
        return raffleCustomers;
    }

    public void setRaffleCustomers(Set<RaffleCustomer> raffleCustomers) {
        this.raffleCustomers = raffleCustomers;
    }

    public RaffleDetail getRaffleDetail() {
        return raffleDetail;
    }

    public void setRaffleDetail(RaffleDetail raffleDetail) {
        this.raffleDetail = raffleDetail;
    }
}
