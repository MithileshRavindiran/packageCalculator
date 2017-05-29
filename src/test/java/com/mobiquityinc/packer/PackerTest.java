package com.mobiquityinc.packer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mithilesh Ravindran.
 */
public class PackerTest {



    private static String filePath;

    @Before
    public void setup() {
        filePath = "src/test/resources/testcases.txt";
    }

    @Test
    public void test_Success_Packing() throws Exception {
        String output = Packer.pack(filePath);
        assertEquals("[ {\r\n  \"weightLimit\" : 81.0,\r\n  \"items\" : [ {\r\n    \"id\" : 4,\r\n    \"weight\" : 72.3,\r\n    \"price\" : 76.0,\r\n    \"currency\" : \"\u20AC\"\r\n  } ],\r\n  \"exceptionReason\" : null\r\n} ]",output);
    }

    @Test
    public void test_Empty_Packaging_Packing() throws Exception {
        String newFilePath = "src/test/resources/testcases1.txt";
        String output = Packer.pack(newFilePath);
        assertEquals("[ {\r\n  \"weightLimit\" : 811.0,\r\n  \"items\" : null,\r\n  \"exceptionReason\" : \"Package limit should be less then 100\"\r\n} ]",output);
    }
}
