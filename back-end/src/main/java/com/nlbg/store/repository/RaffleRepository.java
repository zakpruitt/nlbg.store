package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository<Raffle, Long> {
}
