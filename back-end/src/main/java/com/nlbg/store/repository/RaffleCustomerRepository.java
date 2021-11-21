package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaffleCustomerRepository extends JpaRepository<RaffleCustomer, Long> {
//    @Query("SELECT * " +
//           "FROM raffle_customer " +
//           "WHERE raffle_id = ?1")
//    List<RaffleCustomer> findAllCustomerIds(Long raffleId);
}
