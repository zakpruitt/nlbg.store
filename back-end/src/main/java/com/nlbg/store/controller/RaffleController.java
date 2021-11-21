package com.nlbg.store.controller;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.service.RaffleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/raffles")
public class RaffleController {

    @Autowired
    RaffleService raffleService;

    @GetMapping("/raffleURLs")
    public String displayAllRaffleURLs() {
        StringBuilder sb = new StringBuilder();
        for (Raffle raffle : raffleService.getAllRaffleURLs()) {
            sb.append(raffle.getURL() + " \n");
        }
        return sb.toString().trim();
    }

    @GetMapping("/{raffleURL}")
    public String openRaffleByUrl(@PathVariable String raffleURL) {
        Raffle raffle = null;
        StringBuilder sb = new StringBuilder();
        try {
            raffle = raffleService.getRaffleByURL(raffleURL);
            RaffleDetail raffleDetails = raffle.getRaffleDetail();

            sb.append(raffle.getId() + "\n");
            sb.append(raffleDetails.getItem().getItemName() + "\n");
            sb.append("\n customer with .getRaffleCustomers() test: ");
            for (RaffleCustomer raffleCustomer : raffle.getRaffleCustomers()) {
                sb.append(raffleCustomer.getCustomer().getFirstName() + "\n");
                sb.append(raffleCustomer.getPosition() + "\n");
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return sb.toString().trim();
    }
}
