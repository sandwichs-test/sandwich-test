package com.hwforever.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:40 2017/11/20
 */
public class BeanUtils {
    public static <T> T getBean(Class<T> clazz, HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
