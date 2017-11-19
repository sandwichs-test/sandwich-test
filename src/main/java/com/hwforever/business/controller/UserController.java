package com.hwforever.business.controller;

import com.hwforever.business.model.User;
import com.hwforever.business.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 18:10 2017/11/17
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 用户登录
     * @return
     */
    @PostMapping("/user/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        User user = userService.loginByUserNameAndPassword(request.getParameter("username"),request.getParameter("password"));
        if(user == null){
            throw new RuntimeException("没有匹配的用户信息");
        }
    }
}
