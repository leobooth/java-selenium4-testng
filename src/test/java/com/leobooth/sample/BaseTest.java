package com.leobooth.sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseTest {

  private ArrayList<WebDriver> testDrivers = new ArrayList<>();

  public WebDriver setupTestDriverChrome() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    testDrivers.add(driver);
    return driver;
  }

  public WebDriver setupTestDriverEdge() {
    WebDriverManager.edgedriver().setup();
    WebDriver driver = new EdgeDriver();
    testDrivers.add(driver);
    return driver;
  }

  @AfterMethod
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
