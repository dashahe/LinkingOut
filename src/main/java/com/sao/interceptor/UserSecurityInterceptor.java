package com.sao.interceptor;

import com.sao.config.WebMvcConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserSecurityInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(UserSecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession(true);
        //判断用户ID是否存在，不存在就跳转到登录界面

        logger.info("---------------------preHandle----------------");
        logger.info("------- " + session.getAttribute("uid"));

        if(session.getAttribute("uid") == null){
            logger.info("--------- 跳转到登陆界面");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        } else {
            session.setAttribute("uid", session.getAttribute("uid"));
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }
}
