package com.leobooth.abcMouse;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ABCMouseBaseTest {

  private ArrayList<WebDriver> testDrivers = new ArrayList<>();

  public WebDriver setupTestDriver() {
    WebDriver driver = new ChromeDriver();
    testDrivers.add(driver);
    return driver;
  }

  @AfterTest
  public void tearDown() {
    if (!testDrivers.isEmpty()) {
      for(WebDriver driver : testDrivers) {
        if (driver != null) {
          driver.quit();
        }
      }
    }
  }
}
