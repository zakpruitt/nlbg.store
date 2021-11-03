package com.nlbg.store.domain.Raffle;

import com.nlbg.store.domain.AuditModel;
import com.nlbg.store.domain.Item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class RaffleDetail extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int slotNumbers;
    private int pricePerSlot;
    private boolean full;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raffle_id", referencedColumnName = "id")
    private Raffle raffle;

    public RaffleDetail(int slotNumbers, int pricePerSlot, Item item, Raffle raffle) {
        this.slotNumbers = slotNumbers;
        this.pricePerSlot = pricePerSlot;
        this.item = item;
        this.raffle = raffle;
        this.full = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSlotNumbers() {
        return slotNumbers;
    }

    public void setSlotNumbers(int slotNumbers) {
        this.slotNumbers = slotNumbers;
    }

    public int getPricePerSlot() {
        return pricePerSlot;
    }

    public void setPricePerSlot(int pricePerSlot) {
        this.pricePerSlot = pricePerSlot;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Raffle getRaffle() {
        return raffle;
    }

    public void setRaffle(Raffle raffle) {
        this.raffle = raffle;
    }
}
