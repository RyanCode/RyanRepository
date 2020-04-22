package com.ryan.springbootvue.component;

import com.ryan.springbootvue.mathUtil.RSA;
import com.ryan.springbootvue.service.token.GenAndVerTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Ryan
 * @Date 2020/4/17 15:45
 * version 1.0
 */
public class LoginHandlerInceptor implements HandlerInterceptor,GenAndVerTokenService {
    @Autowired
    GenAndVerTokenService genAndVerTokenService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //get token from request
        String token=getToken(request);
        return RSA.decrypt(token,PRIVATE_KEY).length()>0;
    }
    //获取token
    private String getToken(@NonNull HttpServletRequest request){
        Assert.notNull(request, "Http servlet request must not be null");
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        return token;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    @Override
    public String genToken(String source) throws Exception {
        return null;
    }

    @Override
    public String verToken(String cryptograph) throws Exception {
        return null;
    }
}
