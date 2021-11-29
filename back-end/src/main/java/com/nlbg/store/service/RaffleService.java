package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.domain.Raffle.RaffleExport;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import com.nlbg.store.repository.RaffleCustomerRepository;
import com.nlbg.store.repository.RaffleDetailRepository;
import com.nlbg.store.repository.RaffleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class RaffleService {

    @Autowired
    RaffleRepository raffleRepository;
    @Autowired
    RaffleDetailRepository raffleDetailRepository;
    @Autowired
    RaffleCustomerRepository raffleCustomerRepository;
    @Autowired
    CustomerRepository customerRepository;

    public List<Raffle> getAllRaffleURLs() {
        return raffleRepository.findAll();
    }

    public Raffle getRaffleByURL(String URL) throws NotFoundException {
        return raffleRepository.findByURL(URL)
                .orElseThrow(() -> new NotFoundException("Raffle not found!"));
    }

    public Hashtable<Raffle, ArrayList<Long>> getAllUserRaffles(Customer customer) throws NotFoundException {
        List<RaffleCustomer> raffleCustomers = raffleCustomerRepository.findAllByCustomerId(customer.getId());

        Hashtable<Raffle, ArrayList<Long>> rafflePositionsDictionary = new Hashtable<>();
        for (RaffleCustomer raffleCustomer : raffleCustomers) {
            Raffle currentRaffle = raffleCustomer.getRaffle();
            long position = raffleCustomer.getPosition();

            if (!rafflePositionsDictionary.containsKey(currentRaffle)) {
                rafflePositionsDictionary.put(currentRaffle, new ArrayList<Long>());
            }
            rafflePositionsDictionary.get(currentRaffle).add(position);
        }
        return rafflePositionsDictionary;
    }

    public RaffleExport buildRaffleExport(Raffle raffle, ArrayList<Long> positions, Customer customer) {
        RaffleDetail raffleDetail = raffle.getRaffleDetail();
        Item item = raffleDetail.getItem();

        RaffleExport raffleExport = new RaffleExport();
        raffleExport.setStatus(!raffle.getEndDate().isBefore(LocalDate.now()));
        raffleExport.setStartDate(raffle.getStartDate());
        raffleExport.setEndDate(raffle.getEndDate());
        raffleExport.setItemName(item.getItemName());
        raffleExport.setItemCategory(item.getItemName());
        raffleExport.setRaffleParticipantCount(raffleCustomerRepository.countByRaffle(raffle));
        raffleExport.setPositionsHeld(positions);
        raffleExport.setOutcome(calculateOutcome(raffleExport, raffle, customer));
        raffleExport.setOriginalURL("http://localhost:8080/raffles/" + raffle.getURL());
        return raffleExport;
    }

    private String calculateOutcome(RaffleExport raffleExport, Raffle raffle, Customer customer) {
        long winningCustomerId = 0;
        if (raffle.getCustomer() != null) winningCustomerId = raffle.getCustomer().getId();
        String outcome = "";

        if (raffleExport.getStatus() == false) {
            outcome = "Ongoing";
        } else if (winningCustomerId == customer.getId()) {
            outcome = "Win";
        } else {
            outcome = "Lose";
        }

        return outcome;
    }
}
