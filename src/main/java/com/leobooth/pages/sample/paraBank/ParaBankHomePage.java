package com.leobooth.pages.sample.paraBank;

import com.leobooth.pages.sample.PageObject;
import org.openqa.selenium.WebDriver;

public class ParaBankHomePage extends PageObject {

  final String pageUrl = "https://parabank.parasoft.com/parabank/index.htm";

  final String pageName = "ParaBank home page";

  public ParaBankHomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }
}
