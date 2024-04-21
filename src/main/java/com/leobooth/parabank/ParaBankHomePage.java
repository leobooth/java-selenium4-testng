package com.leobooth.parabank;

import com.leobooth.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class ParaBankHomePage extends BasePage {

  final String pageUrl = "https://parabank.parasoft.com/parabank/index.htm";

  final String pageName = "ParaBank home page";

  public ParaBankHomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }
}
