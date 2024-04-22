package com.leobooth.utils;

public class UrlUtils {

    public static String setUrlParameter(Boolean isFirstParameter, String key, String value) {
        String querySymbol = "";

        if(isFirstParameter) {
            querySymbol = "?";
        } else {
            querySymbol = "&";
        }

        return querySymbol + key + "=" + value;
    }
}
