package com.nlbg.store.config;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.ShippingInformation;
import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.Raffle.RaffleDetail;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.*;
import com.nlbg.store.service.PhotoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

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
    @Autowired
    PhotoService photoService;

    @Bean
    CommandLineRunner testRunner() {
        return args -> {
//            Customer customer = new Customer(
//                    "Zak",
//                    "Pruitt",
//                    "pruittzn@gmail.com",
//                    "206 Arbor Meadows Ct, Fairview Heights, IL",
//                    "206 Arbor Meadows Ct, Fairview Heights, IL"
//            );
//            customerRepository.save(customer);
//
//            Customer customer = customerRepository.findByEmail("zakpruitt5@gmail.com").orElseThrow(() -> new NotFoundException("aa"));
//            System.out.println(Long.toString(Math.round((new Date()).getTime()/1000)));
//            Item predatorAirRush = itemRepository.findByItemName("Predator Air Rush");
//            predatorAirRush.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/par1.png",
//                    UUID.randomUUID().toString(),
//                    predatorAirRush,
//                    "primary"
//            ));
//            predatorAirRush.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/par2.png",
//                    UUID.randomUUID().toString(),
//                    predatorAirRush,
//                    "primary"
//            ));
//            predatorAirRush.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/par3.png",
//                    UUID.randomUUID().toString(),
//                    predatorAirRush,
//                    "primary"
//            ));
//            itemRepository.save(predatorAirRush);
//            Raffle raffle = new Raffle(LocalDate.of(2022, 11, 5),
//                    LocalDate.of(2022, 11, 6));
//            RaffleDetail raffleDetail = new RaffleDetail(20, 20, predatorAirRush, raffle);
//            raffle.setRaffleDetail(raffleDetail);
//            raffleRepository.save(raffle);
//            Customer customer = customerRepository.findByEmail("zakpruitt5@gmail.com").orElseThrow(
//                    () -> new NotFoundException("bruh")
//            );
//            RaffleCustomer raffleCustomer = new RaffleCustomer(raffle, customer, 1);
//            RaffleCustomer raffleCustomer1 = new RaffleCustomer(raffle, customer, 2);
//            RaffleCustomer raffleCustomer2 = new RaffleCustomer(raffle, customer, 3);
//            RaffleCustomer raffleCustomer3 = new RaffleCustomer(raffle, customer, 4);
//            System.out.println(raffle.getRaffleCustomers().size());
//            raffleCustomerRepository.saveAll(Arrays.asList(raffleCustomer, raffleCustomer1, raffleCustomer2, raffleCustomer3));
            System.out.println("Test runner complete.");
        };
    }
}
