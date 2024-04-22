package com.leobooth.mitsubishiclickshop;

import static com.leobooth.utils.UrlUtils.*;

public class ClickshopUrl {

    // https://clickshop.mitsubishicars.com/cars?zip-code=18301&distance=100mi&make=Mitsubishi&condition=new&sortBy=Nearest+distance&page=1

    private final String urlBase = "https://clickshop.mitsubishicars.com/cars";
    private final String zipCodeKey = "zip-code";
    private final String distanceKey= "distance";
    private final String makeKey = "make";
    private final String conditionKey = "condition";
    private final String sortByKey = "sortBy";
    private final String pageKey = "page";
    private final StringBuilder clickShopUrl;

    public ClickshopUrl(String zipCode) {
        clickShopUrl = new StringBuilder();
        clickShopUrl.append(urlBase);
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, zipCodeKey, zipCode));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, distanceKey, "100mi"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, makeKey, "Mitsubishi"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, conditionKey, "new"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, sortByKey,"Nearest+distance"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, pageKey,"1"));
    }

    public String getClickshopUrl() {
        return this.clickShopUrl.toString();
    }
}
