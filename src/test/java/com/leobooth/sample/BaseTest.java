package com.leobooth.sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

  public WebDriver initiateTestDriver() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    return driver;
  }
}
