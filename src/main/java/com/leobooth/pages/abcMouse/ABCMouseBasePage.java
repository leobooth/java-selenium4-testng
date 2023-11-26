package com.leobooth.pages.abcMouse;

import org.openqa.selenium.WebDriver;

public class ABCMouseBasePage {

    public void navToPage(WebDriver driver, String url, String pageName) {
        driver.navigate().to(url);
        System.out.println("navigated to " + pageName);
    }
}
