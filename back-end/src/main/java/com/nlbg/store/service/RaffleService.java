package com.nlbg.store.service;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.repository.RaffleCustomerRepository;
import com.nlbg.store.repository.RaffleDetailRepository;
import com.nlbg.store.repository.RaffleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaffleService {

    @Autowired
    RaffleRepository raffleRepository;
    @Autowired
    RaffleDetailRepository raffleDetailRepository;
    @Autowired
    RaffleCustomerRepository raffleCustomerRepository;

    public Raffle getRaffleByURL(String URL) throws NotFoundException {
        System.out.println(URL);
        return raffleRepository.findByURL(URL)
                .orElseThrow(() -> new NotFoundException("Raffle not found!"));
    }

    public List<Raffle> getAllRaffleURLs() {
        return raffleRepository.findAll();
    }
}
