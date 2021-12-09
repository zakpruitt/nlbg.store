package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import com.nlbg.store.repository.ItemRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemByName(String name) {
        return itemRepository.findByItemName(name);
    }

    public Item getItemById(Long id) throws NotFoundException {
        return itemRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Item not found!")
        );
    }

    public Hashtable<String, Double> getAllItemPrice() {
        List<Item> items = itemRepository.findAll();
        Hashtable<String, Double> itemPrice = new Hashtable<>();
        items.forEach(item -> itemPrice.put(item.getItemName(), item.getItemDesiredValue()));
        return itemPrice;
    }




}
