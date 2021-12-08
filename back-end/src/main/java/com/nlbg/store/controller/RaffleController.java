package com.nlbg.store.controller;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.domain.Raffle.RaffleExport;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import com.nlbg.store.service.CustomerService;
import com.nlbg.store.service.RaffleService;
import com.nlbg.store.service.ShoppingCartService;
import javassist.NotFoundException;
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
    CustomerService customerService;
    @Autowired
    ShoppingCartService shoppingCartService;

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
        Customer customer = customerService.getCustomerByEmail(principal.getName());

        Hashtable<Raffle, ArrayList<Long>> rs = raffleService.getAllUserRaffles(customer);
        ArrayList<RaffleExport> raffleExports = new ArrayList<>();
        for (Map.Entry<Raffle, ArrayList<Long>> kvp : rs.entrySet()) {
            Raffle raffle = kvp.getKey();
            ArrayList<Long> positions = kvp.getValue();
            raffleExports.add(raffleService.buildRaffleExport(raffle, positions, customer));
        }
        model.addAttribute("raffleExports", raffleExports);
        model.addAttribute("shoppingCartSize", shoppingCartService.getCartSize());
        return "raffle_display";
    }

    @GetMapping("/{raffleURL}")
    public String openRaffleByUrl(@PathVariable String raffleURL, Principal principal, Model model) {
        try {
            Raffle raffle = raffleService.getRaffleByURL(raffleURL);
            RaffleDetail raffleDetails = raffle.getRaffleDetail();
            HashMap<Integer, String> namePosition = raffleService.getAllNamePosition(raffle, raffleDetails.getSlotNumbers());

            model.addAttribute("raffle", raffle);
            model.addAttribute("raffleDetails", raffleDetails);
            model.addAttribute("shoppingCartSize", shoppingCartService.getCartSize());
            model.addAttribute("namePositions", namePosition);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "raffle";
    }

    @PostMapping("/{raffleURL}/join")
    public String joinRaffleSpot(@PathVariable String raffleURL, @ModelAttribute("position") String position, Principal principal) {
        try {
            Raffle raffle = raffleService.getRaffleByURL(raffleURL);
            Customer customer = customerService.getCustomerByEmail(principal.getName());

            RaffleCustomer raffleCustomer = new RaffleCustomer(raffle, customer, Integer.parseInt(position));
            raffleService.saveRaffleCustomer(raffleCustomer);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/raffles/" + raffleURL;
    }
}
