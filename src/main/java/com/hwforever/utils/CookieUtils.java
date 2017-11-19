package com.hwforever.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:03 2017/11/19
 */
public class CookieUtils {
    private static final int COOKIE_MAX_AGE = 604800;

    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        if (null != name) {
            Cookie cookie = getCookie(request, name);
            if (null != cookie) {
                cookie.setPath("/");
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

        }
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies && null != name && name.length() != 0) {
            Cookie cookie = null;
            Cookie[] var4 = cookies;
            int var5 = cookies.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Cookie c = var4[var6];
                if (name.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }

            return cookie;
        } else {
            return null;
        }
    }

    public static void setCookie(HttpServletResponse response, String name, String value) {
        setCookie(response, name, value, 604800, true, false);
    }

    public static void setCookie(HttpServletResponse response, String name, String value, boolean secure) {
        setCookie(response, name, value, 604800, secure, false);
    }

    public static void setCookie(HttpServletResponse response, String name, String value, int maxValue, boolean httpOnly, boolean secure) {
        if (null != name) {
            if (null == value) {
                value = "";
            }

            Cookie cookie = new Cookie(name, value);
            cookie.setPath("/");
            cookie.setHttpOnly(httpOnly);
            cookie.setSecure(secure);
            if (maxValue != 0) {
                cookie.setMaxAge(maxValue);
            } else {
                cookie.setMaxAge(604800);
            }

            response.addCookie(cookie);
        }
    }

    private CookieUtils() {
    }
}
