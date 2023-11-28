package com.leobooth.pages.sample;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

  final String pageUrl = "https://the-internet.herokuapp.com/";

  final String pageName = "'The Internet' home page";

  public HomePage(WebDriver driver) {
    super(driver);
    setPageUrl(pageUrl);
    setPageName(pageName);
  }
}
