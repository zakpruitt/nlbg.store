package com.nlbg.store.config;

import com.nlbg.store.domain.Category;
import com.nlbg.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Autowired
    CategoryRepository categoryRepository;

    @Bean
    CommandLineRunner categoryRunner() {
        return args -> {
            Category jumpCueCategory = new Category("Jump Cues","A jump cue is a specific " +
                    "type of pool cue, or stick, which is used to help jump over other balls. The jump cue is " +
                    "usually shorter in length, lighter and has a harder, wider tip on the end.");
            CreateCategoryWithCheck(jumpCueCategory);

            Category breakCueCategory = new Category("Break Cues","A break cue come with " +
                    "hard tips or phenolic tips, and hard tips are known for speeding up ball movements on the board" +
                    " rather than spin. Break shots need a cue tip that can withstand stress, which is a hard tip" +
                    " cue. The tips can last longer and cannot hold much chalk, but they are primarily made for" +
                    " break shots.");
            CreateCategoryWithCheck(breakCueCategory);

            System.out.println("Category runner complete!");
        };
    }

    private void CreateCategoryWithCheck(Category newCategory) {
        if (categoryRepository.findByCategoryName(newCategory.getCategoryName()) == null) {
            categoryRepository.save(newCategory);
        }
    }
}
