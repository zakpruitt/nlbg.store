package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.RaffleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleDetailRepository extends JpaRepository<RaffleDetail, Long> {
}
