package com.nlbg.store.config;

import com.nlbg.store.domain.Item.Category;
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
//            Category jumpCueCategory = new Category("Jump Cues","A jump cue is a specific " +
//                    "type of pool cue, which is used to help jump over other balls. The jump cue is " +
//                    "usually shorter in length, lighter and has a harder, wider tip on the end.");
//            CreateCategoryWithCheck(jumpCueCategory);
//
//            Category breakCueCategory = new Category("Break Cues","A break cue comes with " +
//                    "hard tips or phenolic tips, and hard tips are known for speeding up ball movements" +
//                    " rather than spin. Break shots need a cue tip that can withstand stress, which is a hard tip" +
//                    ". These tips last longer and cannot hold much chalk, but they are primarily made for" +
//                    " break shots.");
//            CreateCategoryWithCheck(breakCueCategory);
//
//            Category playingCueCategory = new Category("Playing Cues","Playing cues are made" +
//                    "for doing just that, playing pool with. They generally come with a soft leather tip to generate" +
//                    "more english (or spin) on the cue ball.");
//            CreateCategoryWithCheck(playingCueCategory);
//
//            Category shaftsCategory = new Category("Shafts","If you're looking to upgrade" +
//                    "your current shaft, we keep up to date with the most popular trends and offer the most sought" +
//                    " after aftermarket shafts.");
//            CreateCategoryWithCheck(shaftsCategory);
//
//            Category glovesCategory = new Category("Gloves","Gloves create a smooth," +
//                    "consistent stroke which is highly desirable in the world of billiards.");
//            CreateCategoryWithCheck(glovesCategory);
//
//            System.out.println("Category runner complete!");
        };
    }

    private void CreateCategoryWithCheck(Category newCategory) {
        if (categoryRepository.findByCategoryName(newCategory.getCategoryName()) == null) {
            categoryRepository.save(newCategory);
        }
    }
}
