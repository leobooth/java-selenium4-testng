package com.leobooth;

import java.util.ArrayList;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

  private ArrayList<WebDriver> testDrivers = new ArrayList<>();

  public enum TestBrowser {
    CHROME, EDGE
  }

  public WebDriver setupTestDriver(TestBrowser testBrowser) {
    switch (testBrowser) {
      case CHROME:
        return setupTestDriverChrome();
      case EDGE:
        return setupTestDriverEdge();
      default:
        throw new InvalidArgumentException("Unknown test browser requested.");
    }
  }

  public WebDriver setupTestDriverChrome() {
    WebDriver driver = new ChromeDriver();
    testDrivers.add(driver);
    return driver;
  }

  public WebDriver setupTestDriverEdge() {
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
