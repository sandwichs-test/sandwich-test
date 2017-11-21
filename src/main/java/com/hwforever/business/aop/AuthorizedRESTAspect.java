package com.hwforever.business.aop;

import com.hwforever.business.mapper.UserMapper;
import com.hwforever.business.model.User;
import com.hwforever.common.Constant;
import com.hwforever.exception.AopException;
import com.hwforever.exception.AuthException;
import com.hwforever.exception.TokenException;
import com.hwforever.utils.AppUtils;
import com.hwforever.utils.BeanUtils;
import com.hwforever.utils.TokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 10:05 2017/11/21
 */
@Aspect
@Component
public class AuthorizedRESTAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(AuthorizedRESTAspect.class);

    @Before("@annotation(com.hwforever.business.aop.AuthorizedREST)")
    public void authrizeREST(JoinPoint joinPoint) throws IOException, TokenException, AopException, AuthException {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        for (Object arg : args) {
            if (HttpServletRequest.class.isAssignableFrom(arg.getClass())) {
                request = (HttpServletRequest) arg;
            }
        }

        if (request == null) {
            LOGGER.error("方法无HttpServletRequest 和 HttpServletResponse 类型形参");
            throw new AopException("错误，请增加 HttpServletRequest 和 HttpServletResponse 类型的形参");
        }
        String token = null;
        token = AppUtils.getClientToken(request, Constant.JWT_TOKEN_COOKIE_NAME);
        Integer uid = TokenUtils.getPrivateClaimFromClientToken(Constant.CLIENT_SANDWICH_NAME, token, Constant.TOKEN_UID_CLAIM, Integer.class);
        User user = BeanUtils.getBean(UserMapper.class,request).selectUserById(uid);
        if (user.getStatus().equals(1)){
            return;
        }else {
            throw new AuthException("该用户无此权限");
        }
    }
}
