package com.mobiquityinc.mapper;

import com.mobiquityinc.domain.ItemPackage;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mithilesh Ravindran
 */
public class ItemsReaderAndMapperTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File tempFile;

    private File tempInvalidFile;

    private ItemsReaderAndMapper readerAndMapper;

    @Before
    public void setup() throws Exception {
        readerAndMapper = new ItemsReaderAndMapper();
        tempFile = tempFolder.newFile("tempFile.txt");
        tempInvalidFile = tempFolder.newFile("tempInvalidFile.txt");
        String data1 = "90 : (2,33.38,€95) (5,18,€18) ";
        String data2 = "110: (10,15.15,€15)";
        String data3 = "110 (10,15.15,€15)";
        List<String> testCase = new ArrayList<>();
        testCase.add(data1);
        testCase.add(data2);
        List<String> invalidTestCase = new ArrayList<>();
        invalidTestCase.add(data3);
        FileUtils.writeLines(tempFile,testCase);
        FileUtils.writeLines(tempInvalidFile,invalidTestCase);
    }

    @Test
    public void test_validTestCase_WithProperDataInFile() throws Exception {
        List<ItemPackage> items = readerAndMapper.readAndMap(tempFile.getAbsolutePath());
        assertEquals(2,items.size());
        assertEquals(90.0, items.get(0).getWeightLimit(),0);
        assertEquals(2, items.get(0).getItems().size());
        assertEquals(1, items.get(1).getItems().size());
        assertEquals(10, items.get(1).getItems().get(0).getId());
    }

    @Test(expected=NumberFormatException.class)
    public void test_invalidTestCase_WithOutProperDataInFile() throws Exception {
        List<ItemPackage> items = readerAndMapper.readAndMap(tempInvalidFile.getAbsolutePath());
    }

    @Test(expected=NumberFormatException.class)
    public void test_invalidTestCase_WithOutProperDataSplitterInFile() throws Exception {
        String data3 = "88!!! + (1,53.38,€45) (2,88.62,€98)";
        List<String> invalidTestCase = new ArrayList<>();
        invalidTestCase.add(data3);
        FileUtils.writeLines(tempInvalidFile,invalidTestCase);
        List<ItemPackage> items = readerAndMapper.readAndMap(tempInvalidFile.getAbsolutePath());
    }


}
