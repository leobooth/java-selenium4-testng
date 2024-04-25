package com.leobooth.mitsubishiclickshop;

import com.leobooth.utils.CSVToDealerZipList;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class CSVToDealerZipListTest {

    @Test
    public void testDealerZipList() {

        ArrayList<CSVToDealerZipList.DealerZip> dealerZipList = new ArrayList<>();

        try {
            dealerZipList = CSVToDealerZipList.convertCSV("/Users/lbooth/Desktop/DealershipsAndZIPCodes-20240425.csv", "," , false);
        } catch (IOException e) {
            Assert.fail("Unable to convert CSV to DealerZipList");
        }

        for (CSVToDealerZipList.DealerZip dealerZip : dealerZipList) {
            System.out.println("Dealer: " + dealerZip.getDealership() + ", ZipCode: " + dealerZip.getZipCode());
        }
    }
}
