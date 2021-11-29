package com.nlbg.store.domain.Raffle;

import java.time.LocalDate;
import java.util.ArrayList;

public class RaffleExport {
    private boolean status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String itemName;
    private String itemCategory;
    private long raffleParticipantCount;
    private ArrayList<Long> positionsHeld;
    private String outcome;
    private String originalURL;

    public RaffleExport() {
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public long getRaffleParticipantCount() {
        return raffleParticipantCount;
    }

    public void setRaffleParticipantCount(long raffleParticipantCount) {
        this.raffleParticipantCount = raffleParticipantCount;
    }

    public ArrayList<Long> getPositionsHeld() {
        return positionsHeld;
    }

    public void setPositionsHeld(ArrayList<Long> positionsHeld) {
        this.positionsHeld = positionsHeld;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }
}
