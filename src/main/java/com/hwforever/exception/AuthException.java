package com.hwforever.exception;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:10 2017/11/19
 */
public class AuthException extends SandwichException{
    public AuthException(){}

    public AuthException(String message){
        super(message);
    }

    public AuthException(String message,Throwable cause){
        super(message,cause);
    }

    public AuthException(Throwable cause){
        super(cause);
    }

    public AuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
