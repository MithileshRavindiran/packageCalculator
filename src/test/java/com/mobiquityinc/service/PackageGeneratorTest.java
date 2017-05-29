package com.mobiquityinc.service;

import com.mobiquityinc.domain.ItemPackage;
import com.mobiquityinc.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Mithilesh Ravindran
 */
public class PackageGeneratorTest {

    private PackageGenerator packageGenerator;

    private List<ItemPackage> packagedItems;

    @Before
    public void setup() {
        packageGenerator = new PackageGenerator();
        packagedItems = TestUtils.createPackagedItems();
    }

    @Test
    public void test_success_collectPackage() {
        ItemPackage packagedItem = packageGenerator.collectPackage(packagedItems.get(0));
        assertEquals(1, packagedItem.getItems().size());
        assertEquals(4, packagedItem.getItems().get(0).getId());
        assertEquals(72.30, packagedItem.getItems().get(0).getWeight(),0);
        assertEquals(76, packagedItem.getItems().get(0).getPrice(),0);
    }

    @Test
    public void test_success_collectPackage_WithException() {
        ItemPackage itemPackage = packagedItems.get(1);
        itemPackage.setExceptionReason("Package limit should be less then 100");
        ItemPackage packagedItem = packageGenerator.collectPackage(itemPackage);
        assertNull(packagedItem.getItems());
        assertEquals("Package limit should be less then 100",packagedItem.getExceptionReason());
    }

}
