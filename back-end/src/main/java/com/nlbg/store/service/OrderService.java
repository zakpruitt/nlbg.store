package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.domain.Order.Order;
import com.nlbg.store.domain.Order.SellOrderForm;
import com.nlbg.store.domain.Order.ShippingInformation;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.ItemRepository;
import com.nlbg.store.repository.OrderRepository;
import com.nlbg.store.repository.ShippingInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShippingInformationRepository shippingInformationRepository;

    @Autowired
    ItemService itemService;
    @Autowired
    PhotoService photoService;

    public void createSellOrder(SellOrderForm sellOrderForm, Customer customer) throws IOException {
        Item item = itemService.getItemByName(sellOrderForm.getItemName());
        if (item == null) {
            // TODO: Handle new category.
            //item = new Item(sellOrderForm.getItemName(), sellOrderForm.getItemPrice(), );
        }

        Order order = new Order(item, customer, 0);
        // TODO: Handle local pickup.
        ShippingInformation shippingInformation = new ShippingInformation(
                true,
                "3608 Quarry Ridge Dr., Evansville, IN 47720",
                sellOrderForm.getShippingAddress(),
                order
        );
        order.setShippingInformation(shippingInformation);
        orderRepository.save(order);
        for (MultipartFile file : sellOrderForm.getPhotos()) {
            order.getSellOrderPhotos().add(photoService.uploadImage(
                    file,
                    UUID.randomUUID().toString(),
                    order,
                    "secondary"
            ));
        }
        orderRepository.save(order);
    }

}
