package com.leobooth.mitsubishiclickshop;

import static com.leobooth.utils.UrlUtils.setUrlParameter;

public class ClickshopUrl {

    // https://clickshop.mitsubishicars.com/cars?zip-code=18301&distance=100mi&make=Mitsubishi&condition=new&sortBy=Nearest+distance&page=1

    private final String urlBase = "https://clickshop.mitsubishicars.com/cars";
    private final String zipCodeKey = "zip-code";
    private final String distanceKey= "distance";
    private final String makeKey = "make";
    private final String conditionKey = "condition";
    private final String sortByKey = "sortBy";
    private final String pageKey = "page";
    private final StringBuilder url;

    public ClickshopUrl(String zipCode) {
        this.url = new StringBuilder();
        this.url.append(urlBase);
        this.url.append(setUrlParameter(true, zipCodeKey, zipCode));
        this.url.append(setUrlParameter(false, distanceKey, "100mi"));
        this.url.append(setUrlParameter(false, makeKey, "Mitsubishi"));
        this.url.append(setUrlParameter(false, conditionKey, "new"));
        this.url.append(setUrlParameter(false, sortByKey,"Nearest+distance"));
        this.url.append(setUrlParameter(false, pageKey,"1"));
    }



    public String getUrl() {
        return this.url.toString();
    }
}
