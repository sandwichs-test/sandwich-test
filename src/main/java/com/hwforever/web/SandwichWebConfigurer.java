package com.hwforever.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 10:49 2017/11/20
 */
@Configuration
public class SandwichWebConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin").excludePathPatterns("/login").excludePathPatterns("/image/**");
        super.addInterceptors(registry);
    }
}
