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
//            Category breakCueCategory = categoryRepository.findByCategoryName("Break Cues");
//            Category playingCueCategory = categoryRepository.findByCategoryName("Playing Cues");
//            Category shaftsCategory = categoryRepository.findByCategoryName("Shafts");
//            Category glovesCategory = categoryRepository.findByCategoryName("Gloves");
//            Category casesCategory = categoryRepository.findByCategoryName("Cases");
//            Category customCueCategory = categoryRepository.findByCategoryName("Custom Cues");

            Item predatorAirRush = new Item("Predator Air Rush", 599.00, jumpCueCategory);
            CreateItemWithCheck(predatorAirRush);
            //region misc code
////            Item predatorAir2IceSportWrap = new Item("Predator Air 2 Ice - Sport Wrap", 289.00, jumpCueCategory);
////            CreateItemWithCheck(predatorAir2IceSportWrap);
////
////            Item predatorAir2IceNoWrap = new Item("Predator Air 2 Ice - No Wrap", 249.00, jumpCueCategory);
////            CreateItemWithCheck(predatorAir2IceNoWrap);
////
////            Item predatorAir2RedSportWrap = new Item("Predator Air 2 Red - Sport Wrap", 289.00, jumpCueCategory);
////            CreateItemWithCheck(predatorAir2RedSportWrap);
////
////            Item predatorAir2RedNoWrap = new Item("Predator Air 2 Red - No Wrap", 249.00, jumpCueCategory);
////            CreateItemWithCheck(predatorAir2RedNoWrap);
////
////            Item predatorAir2SportWrap = new Item("Predator Air 2 - Sport Wrap", 289.00, jumpCueCategory);
////            CreateItemWithCheck(predatorAir2SportWrap);
////
////            Item predatorAir2NoWrap = new Item("Predator Air 2 - No Wrap", 249.00, jumpCueCategory);
////            CreateItemWithCheck(predatorAir2NoWrap);
////
////            Item cuetecPropelBlack = new Item("Cuetec Propel - Black", 429.00, jumpCueCategory);
////            CreateItemWithCheck(cuetecPropelBlack);
////
////            Item cuetecPropelRed = new Item("Cuetec Propel - Red", 429.00, jumpCueCategory);
////            CreateItemWithCheck(cuetecPropelRed);
////
////            Item cuetecPropelGhost = new Item("Cuetec Propel - Ghost", 429.00, jumpCueCategory);
////            CreateItemWithCheck(cuetecPropelGhost);
////
////            Item cuetecBreachGhost = new Item("Cuetec Breach - Ghost", 649.00, breakCueCategory);
////            CreateItemWithCheck(cuetecBreachGhost);
////
////            Item cuetecBreach = new Item("Cuetec Breach", 649.00, breakCueCategory);
////            CreateItemWithCheck(cuetecBreach);
////
////            Item predatorBKRushSportWrapBlue = new Item("Predator BK Rush Blue - Sport Wrap", 749.00, breakCueCategory);
////            CreateItemWithCheck(predatorBKRushSportWrapBlue);
////
////            Item predatorBKRushNoWrapBlue = new Item("Predator BK Rush Blue - No Wrap", 699.00, breakCueCategory);
////            CreateItemWithCheck(predatorBKRushNoWrapBlue);
////
////            Item predatorBKRushSportWrapRed = new Item("Predator BK Rush Red - Sport Wrap", 749.00, breakCueCategory);
////            CreateItemWithCheck(predatorBKRushSportWrapRed);
////
////            Item predatorBKRushNoWrapRed = new Item("Predator BK Rush Red - No Wrap", 699.00, breakCueCategory);
////            CreateItemWithCheck(predatorBKRushNoWrapRed);
////
////            Item predatorBKRushSportWrap = new Item("Predator BK Rush - Sport Wrap", 749.00, breakCueCategory);
////            CreateItemWithCheck(predatorBKRushSportWrap);
////
////            Item predatorBKRushNoWrap = new Item("Predator BK Rush - No Wrap", 699.00, breakCueCategory);
////            CreateItemWithCheck(predatorBKRushNoWrap);
////
////            Item predatorBK2SportWrap = new Item("Predator BK2 - Sport Wrap", 559.00, breakCueCategory);
////            CreateItemWithCheck(predatorBK2SportWrap);
////
////            Item predatorBK2NoWrap = new Item("Predator BK2 - No Wrap", 499.00, breakCueCategory);
////            CreateItemWithCheck(predatorBK2NoWrap);
////
////            Item predatorBK2LinenWrap = new Item("Predator BK2 - Linen Wrap", 529.00, breakCueCategory);
////            CreateItemWithCheck(predatorBK2LinenWrap);
////
////            Item cuetecCynergyBluePackage = new Item("Cuetec Cynergy Pool Cue Package - Blue", 649.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyBluePackage);
////
////            Item cuetecCynergyRedPackage = new Item("Cuetec Cynergy Pool Cue Package - Red", 649.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyRedPackage);
////
////            Item cuetecCynergyWhitePackage = new Item("Cuetec Cynergy Pool Cue Package - White", 649.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyWhitePackage);
////
////            Item cuetecCynergyBlackPackage = new Item("Cuetec Cynergy Pool Cue Package - Black", 649.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyBlackPackage);
////
////            Item cuetecCynergyBlue = new Item("Cuetec Cynergy Pool Cue - Blue", 575.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyBluePackage);
////
////            Item cuetecCynergyRed = new Item("Cuetec Cynergy Pool Cue - Red", 575.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyRedPackage);
////
////            Item cuetecCynergyWhite = new Item("Cuetec Cynergy Pool Cue - White", 575.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyWhitePackage);
////
////            Item cuetecCynergyBlack = new Item("Cuetec Cynergy Pool Cue - Black", 575.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyBlackPackage);
////
////            Item cuetecCynergyLinenWalnut = new Item("Cuetec Cynergy Pool Cue Linen - Walnut", 649.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyLinenWalnut);
////
////            Item cuetecCynergyWraplessWalnut = new Item("Cuetec Cynergy Pool Cue Wrapless - Walnut", 645.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyWraplessWalnut);
////
////            Item cuetecCynergyLinenEbony = new Item("Cuetec Cynergy Pool Cue Linen - Ebony", 649.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyLinenEbony);
////
////            Item cuetecCynergyWraplessEbony = new Item("Cuetec Cynergy Pool Cue Wrapless - Ebony", 645.00, playingCueCategory);
////            CreateItemWithCheck(cuetecCynergyWraplessEbony);
////
////            Item predatorSneakyPeteMidnightWrapless = new Item("Predator Sneaky Pete Midnight - Wrapless", 589.00, playingCueCategory);
////            CreateItemWithCheck(predatorSneakyPeteMidnightWrapless);
////
////            Item predatorSneakyPeteMidnightLinen = new Item("Predator Sneaky Pete Midnight - Linen", 569.00, playingCueCategory);
////            CreateItemWithCheck(predatorSneakyPeteMidnightLinen);
////
////            Item predatorBlak41 = new Item("Predator Blak 4-1", 1149.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlak41);
////
////            Item predatorBlak42 = new Item("Predator Blak 4-2", 1229.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlak42);
////
////            Item predatorBlak43 = new Item("Predator Blak 4-3", 1299.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlak43);
////
////            Item predatorBlak44 = new Item("Predator Blak 4-4", 1429.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlak44);
////
////            Item predatorBlak45 = new Item("Predator Blak 4-5", 1599.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlak45);
////
////            Item predatorIkon41 = new Item("Predator Ikon 4-1", 1349.00, playingCueCategory);
////            CreateItemWithCheck(predatorIkon41);
////
////            Item predatorIkon42 = new Item("Predator Ikon 4-2", 1389.00, playingCueCategory);
////            CreateItemWithCheck(predatorIkon42);
////
////            Item predatorIkon43 = new Item("Predator Ikon 4-3", 1449.00, playingCueCategory);
////            CreateItemWithCheck(predatorIkon43);
////
////            Item predatorIkon44 = new Item("Predator Ikon 4-4", 1509.00, playingCueCategory);
////            CreateItemWithCheck(predatorIkon44);
////
////            Item predatorIkon45 = new Item("Predator Ikon 4-5", 1579.00, playingCueCategory);
////            CreateItemWithCheck(predatorIkon45);
////
////            Item predator9k1 = new Item("Predator 9K-1", 659.00, playingCueCategory);
////            CreateItemWithCheck(predator9k1);
////
////            Item predator9k2 = new Item("Predator 9K-2", 719.00, playingCueCategory);
////            CreateItemWithCheck(predator9k2);
////
////            Item predator9k3 = new Item("Predator 9K-3", 909.00, playingCueCategory);
////            CreateItemWithCheck(predator9k3);
////
////            Item predatorBlackP3NW = new Item("Predator Black P3 - No Wrap", 859.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlackP3NW);
////
////            Item predatorBlackP3Wrap = new Item("Predator Black P3 - Wrap", 909.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlackP3Wrap);
////
////            Item predatorCurlyP3NW = new Item("Predator P3 - No Wrap", 859.00, playingCueCategory);
////            CreateItemWithCheck(predatorBlackP3NW);
////
////            Item meucciCasino1 = new Item("Meucci Casino 1", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino1);
////
////            Item meucciCasino2 = new Item("Meucci Casino 2", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino2);
////
////            Item meucciCasino3 = new Item("Meucci Casino 3", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino3);
////
////            Item meucciCasino4 = new Item("Meucci Casino 4", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino4);
////
////            Item meucciCasino5 = new Item("Meucci Casino 5", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino5);
////
////            Item meucciCasino6 = new Item("Meucci Casino 6", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino6);
////
////            Item meucciCasino7 = new Item("Meucci Casino 7", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino7);
////
////            Item meucciCasino8 = new Item("Meucci Casino 8", 1135.00, playingCueCategory);
////            CreateItemWithCheck(meucciCasino8);
////
////            Item JossJOS74 = new Item("Joss JOS74 Cue", 402.05, playingCueCategory);
////            CreateItemWithCheck(JossJOS74);
////
////            Item JossJOS69 = new Item("Joss JOS69 Cue", 412.25, playingCueCategory);
////            CreateItemWithCheck(JossJOS69);
////
////            Item JossJOS62 = new Item("Joss JOS62 Cue", 353.60, playingCueCategory);
////            CreateItemWithCheck(JossJOS62);
////
////            Item JossJOS61 = new Item("Joss JOS61 Cue", 318.75, playingCueCategory);
////            CreateItemWithCheck(JossJOS61);
////
////            Item JossJOS57 = new Item("Joss JOS57 Cue", 533.80, playingCueCategory);
////            CreateItemWithCheck(JossJOS57);
////
////            Item JossJOS56 = new Item("Joss JOS56 Cue", 495.551, playingCueCategory);
////            CreateItemWithCheck(JossJOS56);
////
////            Item JossJOS55 = new Item("Joss JOS55 Cue", 435.20, playingCueCategory);
////            CreateItemWithCheck(JossJOS55);
////
////            Item JossJOS53 = new Item("Joss JOS53 Cue", 418.20, playingCueCategory);
////            CreateItemWithCheck(JossJOS53);
////
////            Item JossJOS52 = new Item("Joss JOS52 Cue", 359.55, playingCueCategory);
////            CreateItemWithCheck(JossJOS52);
////
////            Item JossJOS50 = new Item("Joss JOS50 Cue", 406.30, playingCueCategory);
////            CreateItemWithCheck(JossJOS50);
////
////            Item JossJOS49 = new Item("Joss JOS49 Cue", 386.75, playingCueCategory);
////            CreateItemWithCheck(JossJOS49);
////
////            Item JossJOS44 = new Item("Joss JOS44 Cue", 481.95, playingCueCategory);
////            CreateItemWithCheck(JossJOS44);
////
////            Item JossJOS21 = new Item("Joss JOS21 Cue", 449.65, playingCueCategory);
////            CreateItemWithCheck(JossJOS21);
////
////            Item JossJOS16 = new Item("Joss JOS16 Cue", 526.15, playingCueCategory);
////            CreateItemWithCheck(JossJOS16);
////
////            Item JossJOS14 = new Item("Joss JOS14 Cue", 355.30, playingCueCategory);
////            CreateItemWithCheck(JossJOS14);
////
////            Item JossJOS12 = new Item("Joss JOS12 Cue", 629.85, playingCueCategory);
////            CreateItemWithCheck(JossJOS12);
////
////            Item JossJOS07 = new Item("Joss JOS07 Cue", 464.10, playingCueCategory);
////            CreateItemWithCheck(JossJOS07);
////
////            Item JossJOS04 = new Item("Joss JOS04 Cue", 407.15, playingCueCategory);
////            CreateItemWithCheck(JossJOS04);
////
////            Item JossJOS02 = new Item("Joss JOS02 Cue", 303.45, playingCueCategory);
////            CreateItemWithCheck(JossJOS02);
////
////            Item JossJOS01 = new Item("Joss JOS01 Cue", 293.25, playingCueCategory);
////            CreateItemWithCheck(JossJOS01);
////
////            Item mezzPowerBreakG = new Item("Mezz Power Break G", 920.00, breakCueCategory);
////            CreateItemWithCheck(mezzPowerBreakG);
////
////            Item mezzAirDrive2 = new Item("Mezz Air Drive II", 510.00, jumpCueCategory);
////            CreateItemWithCheck(mezzAirDrive2);
////
////            Item mezzCP1 = new Item("Mezz ZZCP1 CP-21 Series", 650.00, playingCueCategory);
////            CreateItemWithCheck(mezzCP1);
////
////            Item mezzCP2 = new Item("Mezz ZZCP2 CP-21 Series", 670.00, playingCueCategory);
////            CreateItemWithCheck(mezzCP2);
////
////            Item mezzCP3 = new Item("Mezz ZZCP3 CP-21 Series", 700.00, playingCueCategory);
////            CreateItemWithCheck(mezzCP3);
////
////            Item schonSTL20 = new Item("Schon STL20", 2511.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL20);
////
////            Item schonSTL19 = new Item("Schon STL19", 1903.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL19);
////
////            Item schonSTL18 = new Item("Schon STL18", 1584.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL18);
////
////            Item schonSTL17 = new Item("Schon STL17", 1530.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL17);
////
////            Item schonSTL16 = new Item("Schon STL16", 1336.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL16);
////
////            Item schonSTL15 = new Item("Schon STL15", 1255.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL15);
////
////            Item schonSTL14 = new Item("Schon STL14", 1228.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL14);
////
////            Item schonSTL13 = new Item("Schon STL13", 1201.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL13);
////
////            Item schonSTL12 = new Item("Schon STL12", 1183.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL12);
////
////            Item schonSTL11 = new Item("Schon STL11", 1125.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL11);
////
////            Item schonSTL10 = new Item("Schon STL10", 1059.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL10);
////
////            Item schonSTL9 = new Item("Schon STL9", 963.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL9);
////
////            Item schonSTL8 = new Item("Schon STL8", 922.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL8);
////
////            Item schonSTL7 = new Item("Schon STL7", 868.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL7);
////
////            Item schonSTL6 = new Item("Schon STL6", 846.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL6);
////
////            Item schonSTL5 = new Item("Schon STL5", 832.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL5);
////
////            Item schonSTL4 = new Item("Schon STL4", 688.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL4);
////
////            Item schonSTL3 = new Item("Schon STL3", 688.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL3);
////
////            Item schonSTL2 = new Item("Schon STL2", 661.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL2);
////
////            Item schonSTL1 = new Item("Schon STL1", 647.00, playingCueCategory);
////            CreateItemWithCheck(schonSTL1);
////
////            Item jbCase = new Item("JB Ultimate Rugged Case", 300.00, casesCategory);
////            CreateItemWithCheck(jbCase);
////
////            Item molinariGloves = new Item("Molinari Glove", 29.99, glovesCategory);
////            CreateItemWithCheck(molinariGloves);
//endregion
            System.out.println("Done");
        };
    }

    private void CreateItemWithCheck(Item newItem) {
        if (itemRepository.findByItemName(newItem.getItemName()) == null) {
            itemRepository.save(newItem);
        }
    }
}
