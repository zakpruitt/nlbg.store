package com.nlbg.store.repository;

import com.nlbg.store.domain.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
