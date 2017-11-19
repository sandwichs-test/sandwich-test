package com.hwforever.exception;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:20 2017/11/19
 */
public class TokenException extends SandwichException{
    public TokenException() {
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(Throwable cause) {
        super(cause);
    }

    public TokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
