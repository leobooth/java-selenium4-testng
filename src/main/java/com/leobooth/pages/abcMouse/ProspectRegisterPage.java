package com.leobooth.pages.abcMouse;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProspectRegisterPage extends ABCMouseBasePage implements ABCMousePOInterface {

    WebDriver driver;
    String pageUrl = null;
    String pageName = null;

    public ProspectRegisterPage(WebDriver driver) {
        this.driver = driver;
        this.pageUrl = "https://www.abcmouse.com/abc/prospect-register/";
        this.pageName = "Prospect Register page";
    }

    // PAGE LEVEL
    By bodyBy = By.xpath("//html[@id='prospect-register-page']/body");

    By routeViewBy = By.xpath("route-view");

    By prospectRegisterPageShadowRootBy = By.cssSelector("prospect-register-page");

    By mainLayoutBy = By.cssSelector("main-layout");

    By pageContentBy = By.cssSelector("#page-content");

    By becomeAMemberBy = By.cssSelector("#become-member");

    By emailEntryPanelBy = By.cssSelector("#reg-panels-wrapper");

    public boolean isBrowserOnPage() {
        return driver.getCurrentUrl().contains(pageUrl);
    }

    public void navToPage() {
        super.navToPage(driver, pageUrl, pageName);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    private WebElement getMainLayoutElement() {
        WebElement body = driver.findElement(bodyBy);
        SearchContext routeViewShadowRoot = body.findElement(routeViewBy).getShadowRoot();
        SearchContext prospectRegisterPageShadowRoot = routeViewShadowRoot.findElement(prospectRegisterPageShadowRootBy).getShadowRoot();
        WebElement mainLayout = prospectRegisterPageShadowRoot.findElement(mainLayoutBy);
        return mainLayout;
    }

    private WebElement getPageContentElement() {
        WebElement mainLayoutElement = getMainLayoutElement();
        WebElement pageContentElement = mainLayoutElement.findElement(pageContentBy);
        return pageContentElement;
    }

    public String getBecomeAMemberText() {
        WebElement pageContentElement = getPageContentElement();
        WebElement becomeAMemberElement = pageContentElement.findElement(becomeAMemberBy);
        return becomeAMemberElement.getText();
    }

    private WebElement getEmailEntryPanel() {
        WebElement pageContentElement = getPageContentElement();
        WebElement emailEntryPanelElement = pageContentElement.findElement(emailEntryPanelBy);
        return emailEntryPanelElement;
    }


}
