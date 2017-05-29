package com.mobiquityinc.utils;

import com.mobiquityinc.domain.ItemPackage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mithilesh Ravindran
 */
public class TestUtilsTest {

    @Test
    public void test_Success_TestUtils() {
        List<ItemPackage> pacakagedItem = TestUtils.createPackagedItems();
        assertEquals(4,pacakagedItem.size());
        assertEquals(4,pacakagedItem.get(0).getItems().size());
        assertEquals(5,pacakagedItem.get(1).getItems().size());
        assertEquals(5,pacakagedItem.get(2).getItems().size());
        assertEquals(80,pacakagedItem.get(0).getWeightLimit(),0);
        assertEquals(750,pacakagedItem.get(1).getWeightLimit(),0);
        assertEquals(75,pacakagedItem.get(2).getWeightLimit(),0);
        assertEquals(7,pacakagedItem.get(3).getWeightLimit(),0);


    }
}
