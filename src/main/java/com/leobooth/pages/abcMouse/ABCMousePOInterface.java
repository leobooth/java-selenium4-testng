package com.leobooth.pages.abcMouse;

import org.openqa.selenium.WebDriver;

public interface ABCMousePOInterface {

    WebDriver driver = null;
    String pageUrl = null;
    String pageName = null;

    public boolean isBrowserOnPage();

    public void navToPage();

    public String getPageUrl();

    public String getPageName();

    public String getPageTitle();

}
