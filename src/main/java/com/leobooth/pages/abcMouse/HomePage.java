package com.leobooth.pages.abcMouse;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // HOME
    By homeBodyBy = By.xpath("//html[@id='home-element']/body");
    By routeViewBy = By.xpath("route-view");
    By homeElementShadowRootBy = By.cssSelector("home-element");
    By mainLayoutBy = By.cssSelector("main-layout");

    // HEADER
    By headerBy = By.cssSelector("header");
    By homeHeaderBy = By.cssSelector("home-header");

        // HEADER / SIGNUP BUTTON
        By signupAuthstateContextBy = By.cssSelector("authstate-context:nth-of-type(3)");
        By signupButtonBy = By.cssSelector("signup-button");

    public void navToPage() {
        driver.navigate().to("https://abcmouse.com");
        System.out.println("navigated to Home page");
    }

    private WebElement getHomeHeaderElement() {
        WebElement body = driver.findElement(homeBodyBy);
        SearchContext routeViewShadowRoot = body.findElement(routeViewBy).getShadowRoot();
        SearchContext homeElementShadowRoot = routeViewShadowRoot.findElement(homeElementShadowRootBy).getShadowRoot();
        WebElement mainLayout = homeElementShadowRoot.findElement(mainLayoutBy);
        WebElement header = mainLayout.findElement(headerBy);
        WebElement homeHeader = header.findElement(homeHeaderBy);

        return homeHeader;
    }

    public void clickSignupButton() {
        WebElement header = getHomeHeaderElement();
        WebElement signupAuthstateContext = header.findElement(signupAuthstateContextBy);
        WebElement signupButton = signupAuthstateContext.findElement(signupButtonBy);
        signupButton.click();
        System.out.println("clicked signup button");
    }

//    private SearchContext getSignUpButtonSearchContext

}
