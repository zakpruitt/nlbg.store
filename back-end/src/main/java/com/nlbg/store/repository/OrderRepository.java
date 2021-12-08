package com.nlbg.store.repository;

import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Raffle.RaffleCustomer;
import com.nlbg.store.domain.User.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerId(Customer customer);
}
