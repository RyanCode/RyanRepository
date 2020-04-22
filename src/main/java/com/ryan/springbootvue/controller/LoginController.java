package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.Result;
import com.ryan.springbootvue.entity.User;
import com.ryan.springbootvue.mathUtil.RSA;
import com.ryan.springbootvue.service.token.GenAndVerTokenService;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * @Author Ryan
 * @Date 2020/3/26 21:03
 * version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private GenAndVerTokenService genAndVerTokenService;
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public Result getUserById(@RequestBody User requestUser, HttpSession session) throws Exception {
        String name=requestUser.getName();
        name= HtmlUtils.htmlEscape(name);
        User user = userService.findUserById(name, requestUser.getPassword());


        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=requestUser.getName()+" "+sdf.format(new Date().getTime());
        /**
         * 调用RSA非对称加密算法生成token
         */
        String token=genAndVerTokenService.genToken(str);
//        String token= DigestUtils.md5DigestAsHex(str.getBytes());
        if (null==user){
            return new Result(400,null,user.getIsAdmin());
        }else {
            session.setAttribute("user",user.getName());
            return new Result(200,token,user.getIsAdmin());
        }
    }



}
