package com.bw.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    public static final String COOKIE_NAME_TOKEN = "user_token";
    public static final Integer SESSION_EXPIRE_SECONDS = 1800;

    public static String getCookieValue(HttpServletRequest request,String name){
        Map<String ,String> map = readCookieByRequest(request);
        return map.get(name);
    }

    private static Map<String ,String > readCookieByRequest(HttpServletRequest request){
        Map<String,String > map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            map.put(cookie.getName(),cookie.getValue());
        }
        return map;
    }
}
