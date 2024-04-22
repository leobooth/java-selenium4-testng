package com.leobooth.mitsubishiclickshop.pages;

import com.leobooth.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class VDP extends BasePage {

    private final String pageUrl = "";
    private final String pageName = "Vehicle Detail Page";

    public VDP (WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }


}
