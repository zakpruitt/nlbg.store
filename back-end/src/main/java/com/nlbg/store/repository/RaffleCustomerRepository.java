package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaffleCustomerRepository extends JpaRepository<RaffleCustomer, Long> {
    @Query("SELECT rc " +
            "FROM RaffleCustomer rc " +
            "WHERE rc.customer.id = ?1")
    List<RaffleCustomer> findAllByCustomerId(Long customerId);

    @Query("SELECT rc " +
            "FROM RaffleCustomer rc " +
            "WHERE rc.raffle.id = ?1")
    List<RaffleCustomer> findAllByRaffleId(Long raffleId);

    Long countByRaffle(Raffle raffle);
}
