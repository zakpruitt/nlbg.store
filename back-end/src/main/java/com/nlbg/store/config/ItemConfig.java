package com.nlbg.store.config;

import com.nlbg.store.domain.Item.Category;
import com.nlbg.store.domain.Item.Item;
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
            Category playingCueCategory = categoryRepository.findByCategoryName("Playing Cues");
            Category shaftsCategory = categoryRepository.findByCategoryName("Shafts");
            Category glovesCategory = categoryRepository.findByCategoryName("Gloves");

            Item predatorAirRush = new Item("Predator Air Rush", 599.00, jumpCueCategory);
            CreateItemWithCheck(predatorAirRush);

            Item predatorAir2IceSportWrap = new Item("Predator Air 2 Ice - Sport Wrap", 289.00, jumpCueCategory);
            CreateItemWithCheck(predatorAir2IceSportWrap);

            Item predatorAir2IceNoWrap = new Item("Predator Air 2 Ice - No Wrap", 249.00, jumpCueCategory);
            CreateItemWithCheck(predatorAir2IceNoWrap);

            Item predatorAir2RedSportWrap = new Item("Predator Air 2 Red - Sport Wrap", 289.00, jumpCueCategory);
            CreateItemWithCheck(predatorAir2RedSportWrap);

            Item predatorAir2RedNoWrap = new Item("Predator Air 2 Red - No Wrap", 249.00, jumpCueCategory);
            CreateItemWithCheck(predatorAir2RedNoWrap);

            Item predatorAir2SportWrap = new Item("Predator Air 2 - Sport Wrap", 289.00, jumpCueCategory);
            CreateItemWithCheck(predatorAir2SportWrap);

            Item predatorAir2NoWrap = new Item("Predator Air 2 - No Wrap", 249.00, jumpCueCategory);
            CreateItemWithCheck(predatorAir2NoWrap);

            Item cuetecPropelBlack = new Item("Cuetec Propel - Black", 429.00, jumpCueCategory);
            CreateItemWithCheck(cuetecPropelBlack);

            Item cuetecPropelRed = new Item("Cuetec Propel - Red", 429.00, jumpCueCategory);
            CreateItemWithCheck(cuetecPropelRed);

            Item cuetecPropelGhost = new Item("Cuetec Propel - Ghost", 429.00, jumpCueCategory);
            CreateItemWithCheck(cuetecPropelGhost);

            Item cuetecBreachGhost = new Item("Cuetec Breach - Ghost", 649.00, breakCueCategory);
            CreateItemWithCheck(cuetecBreachGhost);

            Item cuetecBreach = new Item("Cuetec Breach", 649.00, breakCueCategory);
            CreateItemWithCheck(cuetecBreach);

            Item predatorBKRushSportWrapBlue = new Item("Predator BK Rush Blue - Sport Wrap", 749.00, breakCueCategory);
            CreateItemWithCheck(predatorBKRushSportWrapBlue);

            Item predatorBKRushNoWrapBlue = new Item("Predator BK Rush Blue - No Wrap", 699.00, breakCueCategory);
            CreateItemWithCheck(predatorBKRushNoWrapBlue);

            Item predatorBKRushSportWrapRed = new Item("Predator BK Rush Red - Sport Wrap", 749.00, breakCueCategory);
            CreateItemWithCheck(predatorBKRushSportWrapRed);

            Item predatorBKRushNoWrapRed = new Item("Predator BK Rush Red - No Wrap", 699.00, breakCueCategory);
            CreateItemWithCheck(predatorBKRushNoWrapRed);

            Item predatorBKRushSportWrap = new Item("Predator BK Rush - Sport Wrap", 749.00, breakCueCategory);
            CreateItemWithCheck(predatorBKRushSportWrap);

            Item predatorBKRushNoWrap = new Item("Predator BK Rush - No Wrap", 699.00, breakCueCategory);
            CreateItemWithCheck(predatorBKRushNoWrap);

            Item predatorBK2SportWrap = new Item("Predator BK2 - Sport Wrap", 559.00, breakCueCategory);
            CreateItemWithCheck(predatorBK2SportWrap);

            Item predatorBK2NoWrap = new Item("Predator BK2 - No Wrap", 499.00, breakCueCategory);
            CreateItemWithCheck(predatorBK2NoWrap);

            Item predatorBK2LinenWrap = new Item("Predator BK2 - Linen Wrap", 529.00, breakCueCategory);
            CreateItemWithCheck(predatorBK2LinenWrap);

            Item cuetecCynergyBluePackage = new Item("Cuetec Cynergy Pool Cue Package - Blue", 649.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyBluePackage);

            Item cuetecCynergyRedPackage = new Item("Cuetec Cynergy Pool Cue Package - Red", 649.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyRedPackage);

            Item cuetecCynergyWhitePackage = new Item("Cuetec Cynergy Pool Cue Package - White", 649.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyWhitePackage);

            Item cuetecCynergyBlackPackage = new Item("Cuetec Cynergy Pool Cue Package - Black", 649.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyBlackPackage);

            Item cuetecCynergyBlue = new Item("Cuetec Cynergy Pool Cue - Blue", 575.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyBluePackage);

            Item cuetecCynergyRed = new Item("Cuetec Cynergy Pool Cue - Red", 575.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyRedPackage);

            Item cuetecCynergyWhite = new Item("Cuetec Cynergy Pool Cue - White", 575.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyWhitePackage);

            Item cuetecCynergyBlack = new Item("Cuetec Cynergy Pool Cue - Black", 575.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyBlackPackage);

            Item cuetecCynergyLinenWalnut = new Item("Cuetec Cynergy Pool Cue Linen - Walnut", 649.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyLinenWalnut);

            Item cuetecCynergyWraplessWalnut = new Item("Cuetec Cynergy Pool Cue Wrapless - Walnut", 645.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyWraplessWalnut);

            Item cuetecCynergyLinenEbony = new Item("Cuetec Cynergy Pool Cue Linen - Ebony", 649.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyLinenEbony);

            Item cuetecCynergyWraplessEbony = new Item("Cuetec Cynergy Pool Cue Wrapless - Ebony", 645.00, playingCueCategory);
            CreateItemWithCheck(cuetecCynergyWraplessEbony);

            Item predatorSneakyPeteMidnightWrapless = new Item("Predator Sneaky Pete Midnight - Wrapless", 589.00, playingCueCategory);
            CreateItemWithCheck(predatorSneakyPeteMidnightWrapless);

            System.out.println("Item runner complete.");

        };
    }

    private void CreateItemWithCheck(Item newItem) {
        if (itemRepository.findByItemName(newItem.getItemName()) == null) {
            itemRepository.save(newItem);
        }
    }
}
