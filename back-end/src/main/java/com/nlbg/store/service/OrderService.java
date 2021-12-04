package com.nlbg.store.service;

import com.nlbg.store.repository.OrderRepository;
import com.nlbg.store.repository.ShippingInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShippingInformationRepository shippingInformationRepository;



}
