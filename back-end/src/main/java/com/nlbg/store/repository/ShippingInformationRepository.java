package com.nlbg.store.repository;

import com.nlbg.store.domain.Order.ShippingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingInformationRepository extends JpaRepository<ShippingInformation, Long> {
}
