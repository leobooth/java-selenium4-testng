package com.leobooth.abcmouse;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProspectRegisterPage extends ABCMouseBasePage implements ABCMousePOInterface {

    private String pageUrl = "https://www.abcmouse.com/abc/prospect-register/";
    private String pageName = "Prospect Register page";

    public ProspectRegisterPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    // PAGE LEVEL
    By bodyBy = By.xpath("//html[@id='prospect-register-page']/body");

    By routeViewBy = By.xpath("route-view");

    By prospectRegisterPageShadowRootBy = By.cssSelector("prospect-register-page");

    By mainLayoutBy = By.cssSelector("main-layout");

    By pageContentBy = By.cssSelector("#page-content");

    By becomeAMemberBy = By.cssSelector("#become-member");

    By emailEntryPanelBy = By.cssSelector("#reg-panels-wrapper");

    // EMAIL INPUT
    By inputEmailBy = By.cssSelector("input#email");

    By submitButtonBy = By.cssSelector("#submit-button");

    private WebElement getMainLayoutElement() {
        WebElement body = getDriver().findElement(bodyBy);
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

    private WebElement getEmailEntryPanelElement() {
        WebElement pageContentElement = getPageContentElement();
        WebElement emailEntryPanelElement = pageContentElement.findElement(emailEntryPanelBy);
        return emailEntryPanelElement;
    }

    private WebElement getInputEmailElement() {
        WebElement emailEntryPanelElement = getEmailEntryPanelElement();
        WebElement inputEmailElement = emailEntryPanelElement.findElement(inputEmailBy);
        return inputEmailElement;
    }

    public void enterEmailAddress(String emailAddress) {
        WebElement inputEmailElement = getInputEmailElement();
        inputEmailElement.sendKeys(emailAddress);
    }

    public void clickSubmitButton() {
        WebElement emailEntryPanelElement = getEmailEntryPanelElement();
        WebElement submitButtonElement = emailEntryPanelElement.findElement(submitButtonBy);
        submitButtonElement.click();
    }
}
