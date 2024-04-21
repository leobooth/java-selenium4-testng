package com.leobooth.abcmouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptchaPage extends ABCMouseBasePage implements ABCMousePOInterface {

    String pageUrl = "https://www.abcmouse.com/abc/";
    String pageName = "Captcha Page";

    public CaptchaPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    By verifyHumanLabelBy = By.cssSelector(".page-title > h1");

    public boolean isVerifyHumanLabelVisible() {
        return getDriver().findElement(verifyHumanLabelBy).isDisplayed();
    }
}
