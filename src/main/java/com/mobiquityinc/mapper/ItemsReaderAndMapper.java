package com.mobiquityinc.mapper;

import com.mobiquityinc.domain.Item;
import com.mobiquityinc.domain.ItemPackage;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ItemsReaderAndMapper is class that reads data from the file and map it to the ItemPackage domain
 *
 * Created by Mithilesh Ravindran .
 */
public class ItemsReaderAndMapper {

    /**
     * Method to read the file from the file path and map it to the domain object
     *
     * @param filePath of type String hold the file location path
     * @return List of ItemPackages
     * @throws Exception
     */
    public List<ItemPackage> readAndMap(String filePath) throws Exception {
        List<ItemPackage> items;
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            items = lines
                    .map(readAndMapToDomain)
                    .collect(Collectors.toList());
        }
        return items;
    }

    /**
     * Functional Inteface that process through induvidual items in the file on a single line and
     *
     * provides us a domain of item
     *
     */
    private static Function<String, Item> createItemData = item -> {
        String[] itemsData = item.split(",");
        int id = Integer.parseInt(itemsData[0].substring(1));
        double weight = Double.parseDouble(itemsData[1]);
        String currency = itemsData[2].substring(0, 1);
        double price = Double.parseDouble(itemsData[2].substring(1, itemsData[2].length() - 1));
        return new Item(id, weight, price, currency);
    };

    /**
     * Functional Interface method that reads through each line in the file and create a packaged item
     *
     * list of items
     */
    private static Function<String, ItemPackage> readAndMapToDomain = line -> {
        String[] itemsList = StringUtils.split(line, ":");
        ItemPackage itemPackage = null;
        double limit = Double.parseDouble(StringUtils.trim(itemsList[0]));
        List<Item> things = Arrays.asList(StringUtils.trim(itemsList[1]).trim().split(" ")).stream()
                    .map(createItemData)
                    .collect(Collectors.toList());

        itemPackage = new ItemPackage(limit, things);
        return itemPackage;

    };


}
