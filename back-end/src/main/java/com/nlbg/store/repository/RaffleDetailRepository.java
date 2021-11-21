package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.RaffleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RaffleDetailRepository extends JpaRepository<RaffleDetail, Long> {
}
