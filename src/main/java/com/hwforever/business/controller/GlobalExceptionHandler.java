package com.hwforever.business.controller;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxiaoyang on 16/11/28.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public String defaultErrorHandler(HttpServletRequest request, Exception e) {
        Map<String, Object> body = new HashMap<>();
        String msg = e.getMessage();
        if (e.getCause() != null) {
            msg = e.getCause().getMessage();
        }
        body.put("msg", msg);
        LOGGER.error("捕获异常 {}", e);
        return "404";
    }

    @ExceptionHandler(IOException.class)
    public void exceptionHandler(IOException e, HttpServletRequest request) {
        LOGGER.error("捕获异常 {}", e);
    }

}
