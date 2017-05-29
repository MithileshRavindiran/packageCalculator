package com.mobiquityinc.service;

import com.mobiquityinc.domain.Item;
import com.mobiquityinc.domain.ItemPackage;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mithilesh Ravindran .
 */
public class PackageGenerator {

    public ItemPackage collectPackage(ItemPackage packagedItem) {
        List<Item> items = null;
        ItemPackage itemPackage = null;
        if (StringUtils.isBlank(packagedItem.getExceptionReason())) {
            //filter and provides a list of item which is within the weight limit
            items = packagedItem.getItems().stream()
                    .filter(item -> item.getWeight() <= packagedItem.getWeightLimit())
                    .collect(Collectors.toList());
            List<List<Item>> combinations = possiblePackageItemCombinations(items);
            itemPackage = new ItemPackage(packagedItem.getWeightLimit(), searchBestThingsCombination(combinations, packagedItem.getWeightLimit()));
        }else {
            itemPackage = new ItemPackage(packagedItem.getWeightLimit(),null);
            itemPackage.setExceptionReason(packagedItem.getExceptionReason());
        }
        return itemPackage;
    }


    /**
     * Method to generate a possible combinations of the items packages with the weight
     * @param items of type {@link Item}
     * @return List of combination of items
     */
    private List<List<Item>> possiblePackageItemCombinations(List<Item> items) {
        List<List<Item>> combinations = new ArrayList<>();
        for (Item currentThing : items) {
            List<List<Item>> newPossibleCombinations = new ArrayList<>();
            for (List<Item> combination : combinations) {
                List<Item> possibleCombinations = new ArrayList<>();
                possibleCombinations.addAll(combination);
                possibleCombinations.add(currentThing);
                newPossibleCombinations.add(possibleCombinations);
            }
            combinations.addAll(newPossibleCombinations);
            List<Item> current = new ArrayList<>();
            current.add(currentThing);
            combinations.add(current);
        }
        return combinations;
    }


    /**
     * Method to check the good priced and best weighted packages from the list of the items
     *
     * @param itemCombinations of type List holds list of possible combination Items
     * @param limit of type double holds the weight
     * @return
     */
    private List<Item> searchBestThingsCombination(List<List<Item>> itemCombinations, double limit) {
        List<Item> matchedPackage = new ArrayList<>();
        double highestCost = 0;
        double lowestWeight = 100;
        itemCombinations.removeIf(item -> item.stream().mapToDouble(Item::getWeight).sum() > limit);
        for (List<Item> packages : itemCombinations) {
                double combinationWeight = packages.stream().mapToDouble(Item::getWeight).sum();
                double combinationPrice = packages.stream().mapToDouble(Item::getPrice).sum();
                if (combinationPrice > highestCost) {
                    highestCost = combinationPrice;
                    matchedPackage = packages;
                    lowestWeight = combinationWeight;
                } else  {
                    if (combinationPrice == highestCost && combinationWeight < lowestWeight) {
                        matchedPackage = packages;
                        lowestWeight = combinationWeight;
                    }
                }
        }
        return matchedPackage;
    }
}

