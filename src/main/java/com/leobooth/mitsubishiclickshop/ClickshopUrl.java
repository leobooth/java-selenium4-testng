package com.leobooth.mitsubishiclickshop;

public class ClickshopUrl {

    // https://clickshop.mitsubishicars.com/cars?zip-code=18301&distance=100mi&make=Mitsubishi&condition=new&sortBy=Nearest+distance&page=1

    private String urlBase = "https://clickshop.mitsubishicars.com/cars";
    private String zipCodeKey = "zip-code";
    private String distanceKey= "distance";
    private String makeKey = "make";
    private String conditionKey = "condition";
    private String sortByKey = "sortBy";
    private String pageKey = "page";
    private StringBuilder url;

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

    private String setUrlParameter(Boolean isFirstParameter, String key, String value) {
        String querySymbol = "";

        if(isFirstParameter) {
            querySymbol = "?";
        } else {
            querySymbol = "&";
        }

        return querySymbol + key + "=" + value;
    }

    public String getUrl() {
        return this.url.toString();
    }
}
