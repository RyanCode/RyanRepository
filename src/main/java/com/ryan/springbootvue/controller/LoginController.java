package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.Result;
import com.ryan.springbootvue.entity.User;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author Ryan
 * @Date 2020/3/26 21:03
 * version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public Result getUserById(@RequestBody User requestUser, HttpSession session){
        String name=requestUser.getName();
        name= HtmlUtils.htmlEscape(name);
        User user = userService.findUserById(name, requestUser.getPassword());
        /**
         * @param token 用md5算法为网页添加token
         * 获取当前时间戳来生成不同的token对象
         */
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=requestUser.getName()+sdf.format(new Date().getTime());
        String token= DigestUtils.md5DigestAsHex(str.getBytes());
        if (null==user){
            return new Result(400,token,user.getIsAdmin());
        }else {
            session.setAttribute("user",user.getName());
            return new Result(200,token,user.getIsAdmin());
        }
    }



}
