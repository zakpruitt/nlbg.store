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


//
//            Item item = new Item("Test Cue1", 7001, cueCategory);
//            Item item1 = new Item("Test Cue2", 7020, cueCategory);
//            Item item2 = new Item("Test Cue3", 7030, cueCategory);
//
//
//            itemRepository.save(item);
//            itemRepository.save(item1);
//            itemRepository.save(item2);

        };
    }

    private void CreateItemWithCheck(Category newCategory) {
        if (categoryRepository.findByCategoryName(newCategory.getCategoryName()) == null) {
            categoryRepository.save(newCategory);
        }
    }
}
