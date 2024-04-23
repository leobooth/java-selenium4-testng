package com.leobooth.mitsubishiclickshop;

import com.leobooth.BaseTest;
import com.leobooth.mitsubishiclickshop.pages.SearchResultsPage;
import com.leobooth.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ClickShopTest extends BaseTest {

    @Test
    public void testClickShopTile() {
        WebDriver driver = setupTestDriver(TestBrowser.CHROME);
        driver.manage().window().maximize();
        SoftAssert softAssert = new SoftAssert();

        String expectedDealerName = "STROUDSBURG MITSUBISHI";
        int zipCode = 18301;
        int expectedDistance = 1;

        ClickShopUrl urlVDPByZipCode = new ClickShopUrl(zipCode);

        System.out.println(urlVDPByZipCode.getClickshopUrl());

        SearchResultsPage srp = new SearchResultsPage(driver, urlVDPByZipCode.getClickshopUrl());
        srp.navToPage();

        WaitUtils.hardWaitForSeconds(5);

        String clickShopHomePageTitleText = "Shop new Mitsubishi cars near you and pre-qualify | Mitsubishi powered by Drive";
        String actualPageTitle = srp.getPageTitle();
        String expectedPageTitle = clickShopHomePageTitleText;
        System.out.println("Page title: " + actualPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Clickshop home page title is not visible.");

        WaitUtils.hardWaitForSeconds(3);

        String actualDealerName = srp.getSRPTileDealerName(1);
        String actualDistanceAsString = srp.getSRPTileDistance(1);
        int actualDistance = Integer.parseInt(
                actualDistanceAsString.substring(0, actualDistanceAsString.indexOf("mi")).trim()
        );

        System.out.println(actualDealerName);
        System.out.println(actualDistance);

        softAssert.assertEquals(actualDealerName,expectedDealerName,"Unexpected dealer name: " + actualDealerName);
        softAssert.assertEquals(actualDistance, expectedDistance, "Unexpected distance for dealer " + actualDealerName + ": " + actualDistance);

        softAssert.assertAll();
    }
}

