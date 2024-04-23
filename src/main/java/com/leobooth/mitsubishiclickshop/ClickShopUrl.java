package com.leobooth.mitsubishiclickshop;

import static com.leobooth.utils.UrlUtils.*;

public class ClickShopUrl {

    // Production:
    // https://clickshop.mitsubishicars.com/cars?zip-code=18301&distance=100mi&make=Mitsubishi&condition=new&sortBy=Nearest+distance&page=1

    private final String urlBase = "https://clickshop.mitsubishicars.com/cars";
    private final String zipCodeKey = "zip-code";
    private final String distanceKey= "distance";
    private final String makeKey = "make";
    private final String conditionKey = "condition";
    private final String sortByKey = "sortBy";
    private final String pageKey = "page";
    private final StringBuilder clickShopUrl;

    // TODO: change this to use Apache URIBuilder
    // https://stackoverflow.com/questions/19538431/is-there-a-right-way-to-build-a-url
    // https://javadoc.io/doc/org.apache.httpcomponents/httpclient/latest/org/apache/http/client/utils/URIBuilder.html
    // or use Java URI constructor (needs Java 20+)
    // https://www.baeldung.com/java-url
    public ClickShopUrl(int zipCode) {
        clickShopUrl = new StringBuilder();
        clickShopUrl.append(urlBase);
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, zipCodeKey, Integer.toString(zipCode)));
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
