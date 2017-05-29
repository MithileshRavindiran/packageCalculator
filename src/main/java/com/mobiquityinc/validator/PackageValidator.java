package com.mobiquityinc.validator;

import com.mobiquityinc.domain.Item;
import com.mobiquityinc.domain.ItemPackage;
import com.mobiquityinc.exception.APIException;

import java.util.List;

/**
 * Package Validator class is used to validate the package list from the files
 *
 * Created by Mithilesh Ravindran
 */
public class PackageValidator {

    public static final int MAX_WEIGHT_LIMIT = 100;
    public static final int MAX_PRICE_ITEM = 100;
    public static final int MAX_COUNT_ITEM = 15;


    public void validate(List<ItemPackage> packages) {
        packages.forEach(pack -> checkRulesForValidation(pack));
    }

    /**
     * Method to check validation on each packages from the input provides
     * @param packagedItems of type {@link ItemPackage}
     */
    public void checkRulesForValidation(ItemPackage packagedItems)  {
        try {
            checkEligibilityOnPackages(packagedItems);
            for (Item item: packagedItems.getItems()) {
                checkEligibilityOnItem(item);
            }
        } catch (APIException ex) {
            packagedItems.setExceptionReason(ex.getMessage());
        }

    }

    /**
     * Method to check on the eligibility criteria on each item in the input
     * @param item of type {@link Item}
     * @throws APIException
     */
    private void checkEligibilityOnItem(Item item) throws APIException {
        if (item.getWeight() > MAX_WEIGHT_LIMIT) {
            throw new APIException("Individual Item in the list weight should be less then " + MAX_PRICE_ITEM);
        }
        if (item.getPrice() > MAX_PRICE_ITEM) {
            throw new APIException("Individual Item price should be less then " + MAX_PRICE_ITEM);
        }
    }

    /**
     * Method to check on the  eligibility check on the Packages of item from the input
     * @param packagedItem of type {@link ItemPackage}
     * @throws APIException
     */
    private void checkEligibilityOnPackages(ItemPackage packagedItem) throws APIException {
        if (packagedItem.getWeightLimit() > MAX_WEIGHT_LIMIT) {
            throw new APIException("Package limit should be less then " + MAX_WEIGHT_LIMIT);
        }
        if (packagedItem.getItems().size() > MAX_COUNT_ITEM) {
            throw new APIException("Items count in one test case should be less then " + MAX_COUNT_ITEM);
        }
    }
}
