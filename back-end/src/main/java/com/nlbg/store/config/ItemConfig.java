package com.nlbg.store.config;

import com.nlbg.store.domain.Category;
import com.nlbg.store.domain.Item;
import com.nlbg.store.repository.CategoryRepository;
import com.nlbg.store.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Value("${STORE.ENV}")
    private String env;

    @Bean
    CommandLineRunner itemRunner() {
        return args -> {
            Category jumpCueCategory = categoryRepository.findByCategoryName("Jump Cues");
            Category breakCueCategory = categoryRepository.findByCategoryName("Break Cues");


            Item airRush = new Item("Air Rush", 600.00, jumpCueCategory);
            CreateItemWithCheck(airRush);
        };
    }

    private void CreateItemWithCheck(Item newItem) {
        if (itemRepository.findByItemName(newItem.getItemName()) == null) {
            itemRepository.save(newItem);
        }
    }
}
