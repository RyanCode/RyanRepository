package com.ryan.springbootvue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EnableCaching
@MapperScan(value = "com.ryan.springbootvue.mapper")
public class SpringbootVueApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootVueApplication.class, args);
    }

}
