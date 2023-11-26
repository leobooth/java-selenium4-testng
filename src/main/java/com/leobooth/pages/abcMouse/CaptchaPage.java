package com.leobooth.pages.abcMouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptchaPage extends ABCMouseBasePage implements ABCMousePOInterface {

    WebDriver driver;
    String pageUrl = null;
    String pageName = null;

    public CaptchaPage(WebDriver driver) {
        this.driver = driver;
        this.pageUrl = "https://www.abcmouse.com/abc/";
        this.pageName = "Captcha Page";
    }

    By verifyHumanLabelBy = By.cssSelector(".page-title > h1");

    public boolean isBrowserOnPage() {
        return driver.getCurrentUrl().contains(pageUrl);
    }

    public void navToPage() {
        super.navToPage(driver, pageUrl, pageName);
    }

    public boolean isVerifyHumanLabelVisible() {
        return driver.findElement(verifyHumanLabelBy).isDisplayed();
    }
}
