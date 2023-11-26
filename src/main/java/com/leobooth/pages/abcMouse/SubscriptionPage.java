package com.leobooth.pages.abcMouse;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionPage extends ABCMouseBasePage implements ABCMousePOInterface {

  private WebDriver driver;
  private String pageUrl = null;
  private String pageName = null;

  public SubscriptionPage(WebDriver driver) {
    this.driver = driver;
    this.pageUrl = "https://www.abcmouse.com/abc/subscription/";
    this.pageName = "Subscription page";
  }

  // PAGE LEVEL
  By bodyBy = By.xpath("//html[@id='new-member-signup-page']/body");

  By routeViewBy = By.xpath("route-view");

  By shadowRootBy = By.cssSelector("new-member-signup-page");

  By mainLayoutBy = By.cssSelector("main-layout");

  By pageContentBy = By.cssSelector("#page-content");

  By callToActionBy = By.cssSelector("form#subscription-form > h3");

  public boolean isBrowserOnPage() {
    return driver.getCurrentUrl().contains(pageUrl);
  }

  public void navToPage() {
    super.navToPage(driver, pageUrl, pageName);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }

  public String getPageName() {
    return this.pageName;
  }

  private WebElement getMainLayoutElement() {
    WebElement body = driver.findElement(bodyBy);
    SearchContext routeViewShadowRoot = body.findElement(routeViewBy).getShadowRoot();
    SearchContext subscriptionPageShadowRoot = routeViewShadowRoot.findElement(shadowRootBy).getShadowRoot();
    WebElement mainLayout = subscriptionPageShadowRoot.findElement(mainLayoutBy);
    return mainLayout;
  }

  private WebElement getPageContentElement() {
    WebElement mainLayoutElement = getMainLayoutElement();
    WebElement pageContentElement = mainLayoutElement.findElement(pageContentBy);
    return pageContentElement;
  }

  private WebElement getCallToActionElement() {
    WebElement pageContentElement = getPageContentElement();
    WebElement callToActionElement = pageContentElement.findElement(callToActionBy);
    return callToActionElement;
  }

  public String getCallToActionText() {
    WebElement callToActionElement = getCallToActionElement();
    return callToActionElement.getText();
  }
}
