package com.nlbg.store.controller;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.domain.Raffle.RaffleExport;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import com.nlbg.store.service.RaffleService;
import javassist.NotFoundException;
import jdk.internal.joptsimple.util.KeyValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping(path = "/raffles")
public class RaffleController {

    @Autowired
    RaffleService raffleService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/a")
    public String displayAllRaffleURLs(Principal principal) {
        StringBuilder sb = new StringBuilder();
        sb.append(principal.getName() + " \n\n\n\n\n\n\t\t");
        for (Raffle raffle : raffleService.getAllRaffleURLs()) {
            sb.append(raffle.getURL() + " \n");
        }
        return sb.toString().trim();
    }

    @GetMapping("/")
    public String displayAllUserRaffles(Principal principal, Model model) {
        try {
            Customer customer = customerRepository.findByEmail(principal.getName())
                    .orElseThrow(() -> new NotFoundException("Customer not found!"));

            Hashtable<Raffle, ArrayList<Long>> rs = raffleService.getAllUserRaffles(customer);
            ArrayList<RaffleExport> raffleExports = new ArrayList<>();
            for (Map.Entry<Raffle, ArrayList<Long>> kvp : rs.entrySet()) {
                Raffle raffle = kvp.getKey();
                ArrayList<Long> positions = kvp.getValue();
                raffleExports.add(raffleService.buildRaffleExport(raffle, positions, customer));
            }

            model.addAttribute("raffleExports", raffleExports);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return "raffle_display";
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
