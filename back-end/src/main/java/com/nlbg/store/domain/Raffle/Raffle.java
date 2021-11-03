package com.nlbg.store.domain.Raffle;

import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.User.Customer;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Raffle extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @Nullable
    private int winningSlot;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "winning_customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "raffle", cascade = CascadeType.ALL)
    private Set<RaffleCustomer> raffleCustomers;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raffle_details_id", referencedColumnName = "id")
    private RaffleDetail raffleDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getWinningSlot() {
        return winningSlot;
    }

    public void setWinningSlot(int winningSlot) {
        this.winningSlot = winningSlot;
    }

    @Nullable
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(@Nullable Customer customer) {
        this.customer = customer;
    }

    public Set<RaffleCustomer> getRaffleCustomers() {
        return raffleCustomers;
    }

    public void setRaffleCustomers(Set<RaffleCustomer> raffleCustomers) {
        this.raffleCustomers = raffleCustomers;
    }
}
