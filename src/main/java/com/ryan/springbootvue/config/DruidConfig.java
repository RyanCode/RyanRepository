package com.ryan.springbootvue.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.util.Utils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ryan
 * @Date 2020/4/23 14:26
 * version 1.0
 */
@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(DruidDataSourceAutoConfigure.class)
@ConditionalOnProperty(name = "spring.datasource.druid.stat-view-servlet.enabled", havingValue = "true", matchIfMissing = true)
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }
    //配置druid监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> map=new HashMap<>();

//        map.put("loginUsername","admin");
//        map.put("loginPassword","1");
        map.put("allow","");
        map.put("deny","192.168.1.1");
        bean.setInitParameters(map);
        return bean;
    }
    //配置监控filter
    @Bean
    public FilterRegistrationBean WebStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        Map<String,String> initParams=new HashMap<>();

        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setFilter(new WebStatFilter());

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

    /**
     * @Title: removeDruidAdFilterRegistrationBean
     * @Description: 除去页面底部的广告
     * @param: @param properties
     * @param: @return
     * @return: FilterRegistrationBean
     * @throws
     */
    @Bean
    public FilterRegistrationBean removeDruidAdFilterRegistrationBean(DruidStatProperties properties) {
        /**
         * 获取监控页面参数
         */
        DruidStatProperties.StatViewServlet druidConfig = properties.getStatViewServlet();
        /**
         * 获取common.js位置
         */
        String pattern = druidConfig.getUrlPattern() != null ? druidConfig.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
        final String filePath = "support/http/resources/js/common.js";
        /**
         * 利用Filter进行过滤
         */
        Filter filter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                chain.doFilter(request, response);
                response.resetBuffer();
                /**
                 * 获取common文件内容
                 */
                String text = Utils.readFromResource(filePath);
                /**
                 * 利用正则表达式删除<footer class="footer">中的<a>标签
                 */
                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
                text = text.replaceAll("powered.*?shrek.wang</a>", "");
                response.getWriter().write(text);
            }

            @Override
            public void destroy() {
            }
        };
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }
}
