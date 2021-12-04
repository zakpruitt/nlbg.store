package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Hashtable<String, Double> getAllItemPrice() {
        List<Item> items = itemRepository.findAll();
        Hashtable<String, Double> itemPrice = new Hashtable<>();
        items.forEach(item -> itemPrice.put(item.getItemName(), item.getItemDesiredValue()));
        return itemPrice;
    }


}
