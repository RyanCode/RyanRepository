package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ryan
 * @Date 2020/5/20 10:39
 * version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteUser")
    public int deleteUser(@RequestParam String name){
        return userService.deleteUser(name);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/getAllUser")
    public ResponseDto getAllUser(){
        return userService.findUser();
    }
}
