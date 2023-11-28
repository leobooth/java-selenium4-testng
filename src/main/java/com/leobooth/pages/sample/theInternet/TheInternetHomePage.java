package com.leobooth.pages.sample.theInternet;

import com.leobooth.pages.sample.PageObject;
import org.openqa.selenium.WebDriver;

public class TheInternetHomePage extends PageObject {

  final String pageUrl = "https://the-internet.herokuapp.com/";

  final String pageName = "'The Internet' home page";

  public TheInternetHomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }
}
