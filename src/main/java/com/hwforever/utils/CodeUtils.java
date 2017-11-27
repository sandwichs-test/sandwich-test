package com.hwforever.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 11:32 2017/11/20
 */
public class CodeUtils {
    public static String base64Encode(String str) {
        return new String(Base64.encodeBase64(str.getBytes()));
    }

    public static String base64Decode(String str) {
        return new String(Base64.decodeBase64(str));
    }

    public static String md5Encode(String str) {
        return String.valueOf(DigestUtils.md5Hex(str));
    }

    private CodeUtils() {

    }
}
