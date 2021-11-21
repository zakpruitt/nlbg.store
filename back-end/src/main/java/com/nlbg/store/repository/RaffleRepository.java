package com.nlbg.store.repository;

import com.nlbg.store.domain.Raffle.Raffle;
import com.nlbg.store.domain.Token.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaffleRepository extends JpaRepository<Raffle, Long> {
    Optional<Raffle> findByURL(String URL);
}
