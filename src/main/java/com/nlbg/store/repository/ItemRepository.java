package com.nlbg.store.repository;

import com.nlbg.store.domain.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByItemName(String itemName);
}
