package com.hwforever.exception;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:05 2017/11/19
 */
public class AopException extends SandwichException{
    public AopException(){}

    public AopException(String message){
        super(message);
    }

    public AopException(String message, Throwable cause){
        super(message,cause);
    }

    public AopException(Throwable cause){
        super(cause);
    }

    public AopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
