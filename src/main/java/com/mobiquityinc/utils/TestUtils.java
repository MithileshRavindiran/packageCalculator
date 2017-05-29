package com.mobiquityinc.utils;

import com.mobiquityinc.domain.Item;
import com.mobiquityinc.domain.ItemPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mithilesh Ravindran.
 */
public final class TestUtils {


    public static List<ItemPackage> createPackagedItems() {
        List<ItemPackage> packages = new ArrayList<>();
        List<Item> itemsOfOne = createItems();
        List<Item> itemsOfTwo = createItemsTwo();
        List<Item> itemsOfThree = createItemsThree();
        List<Item> itemsOfFour = createItemsFour();
        ItemPackage itemPackageOne = new ItemPackage(80, itemsOfOne);
        ItemPackage itemPackageTwo = new ItemPackage(750, itemsOfTwo);
        ItemPackage itemPackageThree = new ItemPackage(75, itemsOfThree);
        ItemPackage itemPackageFour = new ItemPackage(7, itemsOfFour);
        packages.add(itemPackageOne);
        packages.add(itemPackageTwo);
        packages.add(itemPackageThree);
        packages.add(itemPackageFour);
        return packages;
    }

    public static List<Item> createItems() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1,53.38,45,"€");
        Item item2 = new Item(2,88.62,98,"€");
        Item item3 = new Item(3,78.48,3,"€");
        Item item4 = new Item(4,72.30,76,"€");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        return items;
    }

    public static List<Item> createItemsTwo() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1,85.31,29,"€");
        Item item2 = new Item(2,14.55,74,"€");
        Item item3 = new Item(3,3.98,16,"€");
        Item item4 = new Item(5,63.69,52,"€");
        Item item5 = new Item(7,60.02,74,"€");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        return items;
    }
    public static List<Item> createItemsThree() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1,120.31,29,"€");
        Item item2 = new Item(2,20.55,100,"€");
        Item item3 = new Item(3,31.98,26,"€");
        Item item4 = new Item(5,65.69,62,"€");
        Item item5 = new Item(8,40.02,75,"€");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        return items;
    }

    public static List<Item> createItemsFour() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1,85.31,99,"€");
        Item item2 = new Item(2,14.55,45,"€");
        Item item3 = new Item(3,3.98,167,"€");
        Item item4 = new Item(5,63.69,52,"€");
        Item item5 = new Item(7,60.02,78,"€");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        return items;
    }

}
