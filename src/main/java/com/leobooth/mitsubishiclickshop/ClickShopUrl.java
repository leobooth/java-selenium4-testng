package com.leobooth.mitsubishiclickshop;

import static com.leobooth.utils.UrlUtils.*;

public class ClickShopUrl {

    // Production:
    // https://clickshop.mitsubishicars.com/cars
    // https://clickshop.mitsubishicars.com/cars?zip-code=18301&distance=100mi&make=Mitsubishi&condition=new&sortBy=Nearest+distance&page=1

    // UAT:
    // https://mitsubishi-uat.scusa-apps.autofi.io/cars
    // https://mitsubishi-uat.scusa-apps.autofi.io/cars?zip-code=30303&distance=100mi&make=Mitsubishi&condition=new&sortBy=Nearest+distance&page=1

    private static final String prodBaseUrl = "https://clickshop.mitsubishicars.com/cars";
    private static final String uatBaseUrl  = "https://mitsubishi-uat.scusa-apps.autofi.io/cars";
    private static final String zipCodeKey = "zip-code";
    private static final String distanceKey= "distance";
    private static final String makeKey = "make";
    private static final String conditionKey = "condition";
    private static final String sortByKey = "sortBy";
    private static final String pageKey = "page";

    // TODO: change this to use Apache URIBuilder
    // https://stackoverflow.com/questions/19538431/is-there-a-right-way-to-build-a-url
    // https://javadoc.io/doc/org.apache.httpcomponents/httpclient/latest/org/apache/http/client/utils/URIBuilder.html
    // or use Java URI constructor (needs Java 20+)
    // https://www.baeldung.com/java-url
    public static String getClickShopProdUrl(String zipCode) {
        StringBuilder clickShopUrl = new StringBuilder();
        clickShopUrl.append(prodBaseUrl);
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, zipCodeKey, zipCode));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, distanceKey, "100mi"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, makeKey, "Mitsubishi"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, conditionKey, "new"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, sortByKey,"Nearest+distance"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, pageKey,"1"));

        return clickShopUrl.toString();
    }

    public static String getClickShopUatUrl(String zipCode) {
        StringBuilder clickShopUrl = new StringBuilder();
        clickShopUrl.append(uatBaseUrl);
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, zipCodeKey, zipCode));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, distanceKey, "100mi"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, makeKey, "Mitsubishi"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, conditionKey, "new"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, sortByKey,"Nearest+distance"));
        clickShopUrl.append(buildNextUrlParameter(clickShopUrl, pageKey,"1"));

        return clickShopUrl.toString();
    }
}
