package com.leobooth.sample;

import com.leobooth.WaitUtils;
import com.leobooth.pages.sample.paraBank.ParaBankHomePage;
import com.leobooth.pages.sample.theInternet.TheInternetHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

  @Test
  public void testPageTitleChrome() {
    WebDriver driver = setupTestDriverChrome();
    driver.manage().window().maximize();

    TheInternetHomePage homePage = new TheInternetHomePage(driver);
    homePage.navToPage();
    String expectedTitle = "The Internet";
    String actualTitle = homePage.getPageTitle();
    // TODO: replace with wait for ExpectedCondition
    WaitUtils.hardWaitForSeconds(2);

    Assert.assertEquals(actualTitle, expectedTitle, "Page title did not equal " + expectedTitle);
  }

  @Test
  public void testPageTitleEdge() {
    WebDriver driver = setupTestDriverEdge();
    driver.manage().window().maximize();

    ParaBankHomePage homePage = new ParaBankHomePage(driver);
    homePage.navToPage();
    String expectedTitle = "ParaBank";
    String actualTitle = homePage.getPageTitle();
    // TODO: replace with wait for ExpectedCondition
    WaitUtils.hardWaitForSeconds(2);

    Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not contain " + expectedTitle);
  }
}
