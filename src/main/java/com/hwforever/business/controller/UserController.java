package com.hwforever.business.controller;

import com.hwforever.business.model.User;
import com.hwforever.business.service.UserService;
import com.hwforever.common.Constant;
import com.hwforever.exception.AuthException;
import com.hwforever.utils.CookieUtils;
import com.hwforever.utils.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 18:10 2017/11/17
 */
@Controller
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;


    @RequestMapping("/toLogin")
    public String tologin(){
        return "login";
    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws AuthException {
        User user = userService.loginByUserNameAndPassword(request.getParameter("username"),request.getParameter("password"));
        System.out.println(user);
        if(user == null){
            return "login";
        }
        // 生成 Token
        Map<String, Object> claims = new HashMap<String, Object>();
        String loginstr = LocalTime.now().toString();
        user.setLoginstr(loginstr);
        claims.put("uid", user.getId());
        claims.put("loginstr", user.getLoginstr());
        String token = null;
        try {
            token = TokenUtils.generateClientToken(Constant.CLIENT_SANDWICH_NAME, Constant.CLIENT_BROWSER, claims);
            userService.updateUser(user);
        } catch (Exception e) {
            LOGGER.error("无法生成Token: " + e);
        }

        request.setAttribute("msg","登录成功");

        // 在浏览器种Cookie
        CookieUtils.setCookie(response, Constant.JWT_TOKEN_COOKIE_NAME, token);
        return "redirect:/";
    }

    @RequestMapping("/userCtrl")
    public String userCtrl(HttpServletRequest request){
        List<User> users = userService.selectUserAll();
        request.setAttribute("users",users);
        return "userCtrl";
    }

    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request){
        User user = getUser(request);
        userService.insertUser(user);
        return "redirect:/userCtrl";
    }

    @RequestMapping("/queryUser")
    public String queryUser(HttpServletRequest request){
        User user = getUser(request);
        List<User> users = userService.selectUserLike(user);
        request.setAttribute("users",users);
        return "userCtrl";
    }

    public User getUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
