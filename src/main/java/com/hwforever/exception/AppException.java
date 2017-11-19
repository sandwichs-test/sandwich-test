package com.hwforever.exception;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:05 2017/11/19
 */
public class AppException extends SandwichException{
    public AppException(){}

    public AppException(String message){
        super(message);
    }

    public AppException(String message,Throwable cause){
        super(message,cause);
    }

    public AppException(Throwable cause){
        super(cause);
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
