package com.leobooth.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return driver.getCurrentUrl();
  }
}