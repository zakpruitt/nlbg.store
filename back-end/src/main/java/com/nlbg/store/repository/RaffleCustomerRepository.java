package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleCustomerRepository extends JpaRepository<RaffleCustomer, Long> {
}
