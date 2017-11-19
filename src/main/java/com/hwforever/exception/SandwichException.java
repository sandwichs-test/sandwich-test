package com.hwforever.exception;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:10 2017/11/19
 */
public class SandwichException extends Exception{
    public SandwichException(){
    }

    public SandwichException(String message){
        super(message);
    }

    public SandwichException(String message,Throwable cause){
        super(message,cause);
    }

    public SandwichException(Throwable cause){
        super(cause);
    }

    public SandwichException(String message,Throwable cause,boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
