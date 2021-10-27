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
    CommandLineRunner itemRunner(ItemRepository itemRepository) {
        return args -> {

            System.out.println("true");
            Category category = new Category();
            category.setCategoryName("Cue");
            category.setCategoryDescription("This category contains all items relating to billiard cues. This includes yada, yadada, and yada.");
            categoryRepository.save(category);

            Item item = new Item();
            item.setItemName("Lightning Test Cue");
            item.setItemAverageValue(645.43);
            item.setItemDesiredValue(700);
            item.setCategory(category);

            itemRepository.save(item);




        };
    }

    private void CreateItem() {

    }
}
