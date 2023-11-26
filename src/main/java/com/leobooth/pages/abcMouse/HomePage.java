package com.leobooth.pages.abcMouse;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ABCMouseBasePage implements ABCMousePOInterface {

    private WebDriver driver;
    private String pageUrl;
    private String pageName;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.pageUrl = "https://www.abcmouse.com/";
        this.pageName = "Home page";
    }

    public HomePage(WebDriver driver, String url) {
        this.driver = driver;
        this.pageUrl = url;
        this.pageName = "Home page";
    }

    // PAGE LEVEL
    By bodyBy = By.xpath("//html[@id='home-element']/body");
    By routeViewBy = By.xpath("route-view");
    By homeElementShadowRootBy = By.cssSelector("home-element");
    By mainLayoutBy = By.cssSelector("main-layout");

    // HEADER
    By headerBy = By.cssSelector("header");
    By homeHeaderBy = By.cssSelector("home-header");

        // HEADER / SIGNUP BUTTON
        By signupAuthstateContextBy = By.cssSelector("authstate-context:nth-of-type(3)");
        By signupButtonBy = By.cssSelector("signup-button");

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

    private WebElement getHomeHeaderElement() {
        WebElement body = driver.findElement(bodyBy);
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
    }
}
