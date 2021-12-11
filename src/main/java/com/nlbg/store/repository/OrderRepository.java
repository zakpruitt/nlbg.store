package com.nlbg.store.repository;

import com.nlbg.store.domain.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerId(Long id);

    @Query("SELECT so " +
            "FROM Order so " +
            "WHERE so.orderType = 'Sell'")
    List<Order> findAllSellOrders();

    @Query("SELECT so " +
            "FROM Order so " +
            "WHERE so.orderType = 'Purchase'")
    List<Order> findAllPurchaseOrders();
}
