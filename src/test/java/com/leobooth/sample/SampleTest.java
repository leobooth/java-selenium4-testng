package com.leobooth.sample;

import com.leobooth.WaitUtils;
import com.leobooth.pages.sample.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

  @Test
  public void testPageTitle() {
    WebDriver driver = setupTestDriver();
    driver.manage().window().maximize();

    HomePage homePage = new HomePage(driver);
    homePage.navToPage();
    String expectedTitle = "The Internet";
    String actualTitle = driver.getTitle();
    // TODO: replace with wait for ExpectedCondition
    WaitUtils.hardWaitForSeconds(2);

    Assert.assertEquals(actualTitle, expectedTitle, "Page title did not equal " + expectedTitle);
  }
}
