package com.hwforever.business.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 10:04 2017/11/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthorizedREST {
    /**
     * 自定义注解，权限验证
     */
}
