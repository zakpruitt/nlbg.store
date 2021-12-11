package com.nlbg.store.config;

import com.nlbg.store.repository.*;
import com.nlbg.store.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
//            Customer customer = customerRepository.findByEmail("billiardgeartv@gmail.com").orElseThrow(() -> new NotFoundException("aa"));
////            System.out.println(Long.toString(Math.round((new Date()).getTime()/1000)));
//            Item predatorAirRush = itemRepository.findByItemName("Predator Air Rush"); //6
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
//
//            Item airIce = itemRepository.findByItemName("Predator Air 2 Ice - Sport Wrap"); //213
//            airIce.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/AirIce.jpg",
//                    UUID.randomUUID().toString(),
//                    airIce,
//                    "primary"
//            ));
//            airIce.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/AirIce2.jpg",
//                    UUID.randomUUID().toString(),
//                    airIce,
//                    "primary"
//            ));
//            airIce.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/AirIce3.jpg",
//                    UUID.randomUUID().toString(),
//                    airIce,
//                    "primary"
//            ));
//
//            Item ghost = itemRepository.findByItemName("Cuetec Propel - Ghost"); //221
//            ghost.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/cuetecPropel.jpg",
//                    UUID.randomUUID().toString(),
//                    ghost,
//                    "primary"
//            ));
//            ghost.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/cuetecPropel2.jpg",
//                    UUID.randomUUID().toString(),
//                    ghost,
//                    "primary"
//            ));
//            ghost.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/cuetecPropel3.jpg",
//                    UUID.randomUUID().toString(),
//                    ghost,
//                    "primary"
//            ));
//
//            Item ghSVB = itemRepository.findByItemName("Cuetec Breach - Ghost"); //222
//            ghSVB.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/SVBGhost.jpg",
//                    UUID.randomUUID().toString(),
//                    ghSVB,
//                    "primary"
//            ));
//            ghSVB.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/SVBGhost2.jpg",
//                    UUID.randomUUID().toString(),
//                    ghSVB,
//                    "primary"
//            ));
//            ghSVB.getPhotos().add(photoService.uploadImage(
//                    "C:/Users/pruit/Desktop/SVBGhost3.jpg",
//                    UUID.randomUUID().toString(),
//                    ghSVB,
//                    "primary"
//            ));
//
//
//            itemRepository.save(predatorAirRush);
//            itemRepository.save(airIce);
//            itemRepository.save(ghost);
//            itemRepository.save(ghSVB);
//            Raffle raffle = new Raffle(LocalDate.of(2021, 11, 5),
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
//            System.out.println("Test runner complete.");
        };
    }
}
