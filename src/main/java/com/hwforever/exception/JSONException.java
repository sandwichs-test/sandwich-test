package com.hwforever.exception;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:15 2017/11/19
 */
public class JSONException extends SandwichException{
    public JSONException(){}

    public JSONException(String message){
        super(message);
    }

    public JSONException(String message,Throwable cause){
        super(message,cause);
    }

    public JSONException(Throwable cause){
        super(cause);
    }

    public JSONException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
