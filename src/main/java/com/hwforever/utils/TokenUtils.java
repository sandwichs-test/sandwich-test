package com.hwforever.utils;

import com.hwforever.exception.TokenException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:04 2017/11/19
 */
public class TokenUtils {
    public static String generateClientToken(String iss, String aud, Map<String, Object> claims) throws TokenException {
        String token = null;

        try {
            Builder builder = JWT.create().withIssuer(iss).withAudience(new String[]{aud}).withIssuedAt(new Date());
            Map.Entry claim;
            if (claims != null && claims.size() != 0) {
                for(Iterator var5 = claims.entrySet().iterator(); var5.hasNext(); builder = builder.withClaim((String)claim.getKey(), claim.getValue())) {
                    claim = (Map.Entry)var5.next();
                }
            }

            token = builder.sign(Algorithm.HMAC256("secret"));
            return token;
        } catch (Exception var7) {
            throw new TokenException("生成Token异常:" + var7.getStackTrace());
        }
    }

    public static <T> T getPrivateClaimFromClientToken(String iss, String token, String key, Class<T> type) throws TokenException {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret")).withIssuer(iss).build();
            JWT jwt = (JWT)verifier.verify(token);
            Claim claim = jwt.getClaim(key);
            if (type.isAssignableFrom(Boolean.class)) {
                return (T) claim.asBoolean();
            } else if (type.isAssignableFrom(Integer.class)) {
                return (T) claim.asInt();
            } else if (type.isAssignableFrom(Double.class)) {
                return (T) claim.asDouble();
            } else if (type.isAssignableFrom(String.class)) {
                return (T) claim.asString();
            } else if (type.isAssignableFrom(Date.class)) {
                return (T) claim.asDate();
            } else {
                throw new TokenException("不支持的Claim异常");
            }
        } catch (Exception var7) {
            throw new TokenException("校验并解析Token失败:" + var7.getStackTrace());
        }
    }

    public static boolean validateJWTToken(String iss, String token) {
        boolean result = false;

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret")).withIssuer(iss).build();
            verifier.verify(token);
            if (verifier != null) {
                result = true;
            }
        } catch (Exception var5) {
            result = false;
        }

        return result;
    }

    private TokenUtils() {
    }
}
