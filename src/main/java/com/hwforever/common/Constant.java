package com.hwforever.common;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:29 2017/11/19
 */
public class Constant {
    //JWT token中 uid的名称
    public static final String TOKEN_UID_CLAIM = "uid";
    //JWT token中 loginstr的名称
    public static final String TOKEN_LOGINSTR_CLAIM = "loginstr";

    //浏览器中JWT cookie的名称
    public static final String JWT_TOKEN_COOKIE_NAME = "CLIENTID";

    //应用默认名称
    public static final String CLIENT_SANDWICH_NAME = "sandwich";

    //访问来源为普通浏览器
    public static final String CLIENT_BROWSER = "browser";
}
