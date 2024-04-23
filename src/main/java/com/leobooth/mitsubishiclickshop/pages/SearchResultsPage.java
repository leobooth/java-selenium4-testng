package com.leobooth.mitsubishiclickshop.pages;

import com.leobooth.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchResultsPage extends BasePage {

    private final String pageUrl = "";
    private final String pageName = "Search Results Page (SRP)";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    public SearchResultsPage(WebDriver driver, String url) {
        super(driver);
        this.setPageUrl(url);
        this.setPageName(pageName);
    }

    By srpTileSelector = By.xpath(
            "//div[contains(@class,'col-span')][descendant::span[@role='button'][child::a[contains(@href,'/vehicle/')]]]"
    );

    By srpTileInfoSelector = By.xpath(
            "//descendant::div[contains(@class,'relative')]/following-sibling::span"
    );

        By chainDealerName = By.xpath(
                "/descendant::div[contains(@class,'flex-col')][position()=2]/descendant::p[position()=1]"
        );

        By chainDealerDistance = By.xpath(
                "/descendant::div[contains(@class,'flex-col')][position()=2]/descendant::p[position()=3]"
        );


    By srpTileDealerNameSelector = By.xpath(
            "//descendant::div[contains(@class,'relative')]/following-sibling::span/descendant::div[contains(@class,'flex-col')][position()=2]/descendant::p[position()=1]"
    );

    By srpTileDealerDistanceSelector = By.xpath(
            "//descendant::div[contains(@class,'relative')]/following-sibling::span/descendant::div[contains(@class,'flex-col')][position()=2]/descendant::p[position()=3]"
    );


    public String getSRPTileDealerName(int tileNumber) {
        ArrayList<WebElement> dealerNames = new ArrayList<>(getDriver().findElements(srpTileDealerNameSelector));

        if(!dealerNames.isEmpty()) {
            return dealerNames.get(tileNumber).getText();
        } else {
            return "no result";
        }
    }

    public String getSRPTileDistance(int tileNumber) {
        ArrayList<WebElement> dealerDistances = new ArrayList<>(getDriver().findElements(srpTileDealerDistanceSelector));

        if(!dealerDistances.isEmpty()) {
            return dealerDistances.get(tileNumber).getText();
        } else {
            return "no result";
        }
    }
}
