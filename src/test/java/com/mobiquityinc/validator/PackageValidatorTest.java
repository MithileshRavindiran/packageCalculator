package com.mobiquityinc.validator;

import com.mobiquityinc.domain.ItemPackage;
import com.mobiquityinc.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mithilesh Ravindran
 */
public class PackageValidatorTest {

    private PackageValidator packageValidator;

    private List<ItemPackage> packagedItems;

    @Before
    public void setup() {
        packageValidator = new PackageValidator();
         packagedItems = TestUtils.createPackagedItems();
    }

    @Test
    public void test_Success_Validation() {
        packageValidator.validate(packagedItems);
        assertEquals(4,packagedItems.size());
        assertEquals(4,packagedItems.get(0).getItems().size());
        assertEquals("Package limit should be less then 100",packagedItems.get(1).getExceptionReason());
        assertEquals("Individual Item in the list weight should be less then 100",packagedItems.get(2).getExceptionReason());
        assertEquals(5,packagedItems.get(3).getItems().size());
    }




}
