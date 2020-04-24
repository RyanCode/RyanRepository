package com.ryan.springbootvue.component;

import com.ryan.springbootvue.mathUtil.RSA;
import com.ryan.springbootvue.service.token.GenAndVerTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Ryan
 * @Date 2020/4/17 15:45
 * version 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
    @Autowired
    private GenAndVerTokenService genAndVerTokenService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //get token from request
        String token=request.getHeader(HttpHeaders.AUTHORIZATION);
        /**
         * 简单判断铭文是否解析正常
         */
        return request.getRequestURI().equals("/Ryan/druid")||request.getMethod().equals("OPTIONS")||RSA.decrypt(token, genAndVerTokenService.PRIVATE_KEY).length() > 0;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
