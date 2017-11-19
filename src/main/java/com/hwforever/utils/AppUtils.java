package com.hwforever.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

import com.hwforever.exception.JSONException;
import com.hwforever.exception.TokenException;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:04 2017/11/19
 */
public class AppUtils {
    public AppUtils() {
    }

    public static String getClientToken(HttpServletRequest request, String cookieName) throws IOException, TokenException {
        String token = null;
        token = request.getParameter("token");
        if (StringUtils.isNotEmpty(token)) {
            return token;
        } else {
            String contentType = request.getContentType();
            if (StringUtils.equals(contentType, "application/json")) {
                String jsonContent = null;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = request.getReader();

                String line;
                try {
                    while((line = reader.readLine()) != null) {
                        builder.append(line).append('\n');
                    }
                } finally {
                    reader.close();
                }

                jsonContent = builder.toString();

                try {
                    token = (String)JSONUtils.getValue(jsonContent, "token", String.class);
                    if (StringUtils.isNotEmpty(token)) {
                        return token;
                    }
                } catch (JSONException var11) {
                    ;
                }
            }

            Cookie cookie = CookieUtils.getCookie(request, cookieName);
            if (cookie != null && StringUtils.isNotEmpty(cookie.getValue())) {
                return cookie.getValue();
            } else {
                throw new TokenException("用户Token缺失");
            }
        }
    }
}
