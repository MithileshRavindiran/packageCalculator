package com.mobiquityinc.packer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquityinc.domain.ItemPackage;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.mapper.ItemsReaderAndMapper;
import com.mobiquityinc.service.PackageGenerator;
import com.mobiquityinc.validator.PackageValidator;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Class which initialize the packing process by reading the items and limit from the file
 *
 * and providing the best package solution
 *
 * Created by Mithilesh Ravindran
 */
public class Packer {

    private static  ItemsReaderAndMapper itemsReaderAndMapper = new ItemsReaderAndMapper();

    private static  PackageValidator packageValidator = new PackageValidator();

    private static PackageGenerator packageGenerator = new PackageGenerator();



    /**
     * Method gets the  path for the package from the upload and feciliate  to other services to get the
     * best sized package
     *
     * @param filePath absolute path to a test file
     * @return best packages for each test cases in string format
     */
    public static String pack(String filePath) throws APIException {
        List<ItemPackage> items;
        String jsonInString = null;
        try {
            items = itemsReaderAndMapper.readAndMap(filePath);
            packageValidator.validate(items);
            List<ItemPackage> itemPackageList = items.stream().map(packageGenerator::collectPackage).collect(Collectors.toList());
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(itemPackageList);
            System.out.println("Output best packages id");
            itemPackageList.stream().map(ItemPackage::toString).collect(Collectors.toList()).forEach(System.out::println);
        } catch (Exception ex) {
            throw new APIException("Error during packing: " + ex);
        }
        return jsonInString;
    }



}

