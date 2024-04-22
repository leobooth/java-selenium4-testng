package com.leobooth.utils;

public class UrlUtils {

    public static String buildUrlParameter(Boolean isFirstParameter, String key, String value) {
        String querySymbol = "";

        if(isFirstParameter) {
            querySymbol = "?";
        } else {
            querySymbol = "&";
        }

        return querySymbol + key + "=" + value;
    }

    public static String buildNextUrlParameter(StringBuilder url, String key, String value) {
        String urlParameter = "";

        if(url.indexOf("?") == -1) {
            urlParameter = buildUrlParameter(true, key, value);
        } else {
            urlParameter = buildUrlParameter(false, key, value);
        }

        return urlParameter;
    }
}
