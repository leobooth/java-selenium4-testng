package com.leobooth.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;
    private String pageUrl = null;
    private String pageName = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(WebDriver driver, String pageUrl, String pageName) {
        this.driver = driver;
        this.pageUrl = pageUrl;
        this.pageName = pageName;
    }

    protected void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    protected void setPageName(String pageName) {
        this.pageName = pageName;
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public boolean isBrowserOnPage() {
        return driver.getCurrentUrl().contains(pageUrl);
    }

    public void navToPage() {
        driver.navigate().to(pageUrl);
        System.out.println("navigated to " + pageName);  }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageName() {
        return this.pageName;
    }
}
