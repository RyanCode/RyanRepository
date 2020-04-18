package com.ryan.springbootvue.config;

import com.ryan.springbootvue.component.LoginHandlerInceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

/**
 * @Author Ryan
 * @Date 2020/4/17 12:27
 * version 1.0
 */
@Configuration
public class MyMvcConifg implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT","HEAD","OPTIONS")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInceptor()).addPathPatterns("/**")
        .excludePathPatterns("/login");
    }
}
