package com.nlbg.store.repository;

import com.nlbg.store.domain.User.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
