package com.nlbg.store.config;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.ShippingInformation;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Configuration
public class TestConfig {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShippingInformationRepository shippingInformationRepository;
    @Autowired
    RaffleRepository raffleRepository;
    @Autowired
    RaffleDetailRepository raffleDetailRepository;
    @Autowired
    RaffleCustomerRepository raffleCustomerRepository;

    @Bean
    CommandLineRunner testRunner() {
        return args -> {
//            Customer customer = new Customer(
//                    "Zak",
//                    "Pruitt",
//                    "pruittzn@gmail.com",
//                    "6185934183",
//                    "206 Arbor Meadows Ct, Fairview Heights, IL",
//                    "206 Arbor Meadows Ct, Fairview Heights, IL"
//            );
//            customerRepository.save(customer);
//
            Item predatorAirRush = itemRepository.findByItemName("Predator Air Rush");
//
//            Order order = new Order(predatorAirRush, customer);
//            ShippingInformation shippingInformation = new ShippingInformation(true, customer, order);
//            order.setShippingInformation(shippingInformation);
//            orderRepository.save(order);

            Raffle raffle = new Raffle(LocalDate.of(2022, 11, 5),
                                       LocalDate.of(2022, 11, 6));
            RaffleDetail raffleDetail = new RaffleDetail(20, 20, predatorAirRush, raffle);
            raffle.setRaffleDetail(raffleDetail);
            raffleRepository.save(raffle);
//
//            RaffleCustomer raffleCustomer = new RaffleCustomer(raffle, customer, 1);
//            RaffleCustomer raffleCustomer1 = new RaffleCustomer(raffle, customer, 2);
//            RaffleCustomer raffleCustomer2 = new RaffleCustomer(raffle, customer, 3);
//            RaffleCustomer raffleCustomer3 = new RaffleCustomer(raffle, customer, 4);
//            raffleCustomerRepository.saveAll(Arrays.asList(raffleCustomer, raffleCustomer1, raffleCustomer2, raffleCustomer3));
//            System.out.println("Test runner complete.");

        };
    }
}
