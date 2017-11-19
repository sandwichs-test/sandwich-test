package com.hwforever.web;

import com.hwforever.business.model.User;
import com.hwforever.business.service.UserService;
import com.hwforever.common.Constant;
import com.hwforever.exception.AuthException;
import com.hwforever.utils.AppUtils;
import com.hwforever.utils.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义拦截器
 * @Author： ZhangQiufeng
 * @Description： 用户登录拦截器
 * @Date： Created in 13:42 2017/11/19
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String token = null;
        try {
            token = AppUtils.getClientToken(request, Constant.JWT_TOKEN_COOKIE_NAME);
            Integer uid = TokenUtils.getPrivateClaimFromClientToken(Constant.CLIENT_SANDWICH_NAME, token, Constant.TOKEN_UID_CLAIM, Integer.class);
            String loginstr = TokenUtils.getPrivateClaimFromClientToken(Constant.CLIENT_SANDWICH_NAME, token, Constant.TOKEN_LOGINSTR_CLAIM, String.class);
            User user = userService.selectUserById(uid);
            if (user.getLoginstr().equals(loginstr)){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
