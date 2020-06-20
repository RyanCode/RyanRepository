package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.Result;
import com.ryan.springbootvue.entity.Journals;
import com.ryan.springbootvue.entity.User;
import com.ryan.springbootvue.service.token.GenAndVerTokenService;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private GenAndVerTokenService genAndVerTokenService;
    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    public Result getUserById(@RequestBody User requestUser,HttpSession session, HttpServletRequest request) throws Exception {
        String name=requestUser.getName();
        name= HtmlUtils.htmlEscape(name);
        User user = userService.findUserById(name, requestUser.getPassword());

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=name +" "+sdf.format(new Date().getTime());
        /**
         * 调用RSA非对称加密算法生成token
         */
//        String token= DigestUtils.md5DigestAsHex(str.getBytes());
        Journals journals=new Journals();
        if (null==user){
            journals.setIp(request.getRemoteAddr());
            journals.setAcc(requestUser.getName());
            journals.setStatus(false);
            journals.setDate(sdf.format(new Date().getTime()));
            userService.insertJournal(journals);
            return new Result(400,null,null);
        }else {
            journals.setIp(request.getRemoteAddr());
            journals.setAcc(requestUser.getName());
            journals.setStatus(true);
            journals.setDate(sdf.format(new Date().getTime()));
            userService.insertJournal(journals);
            String token=genAndVerTokenService.genToken(str);
            System.out.println(token);
            session.setAttribute("user",user);
            return new Result(200,token,user.getIsAdmin());
        }
    }
}
