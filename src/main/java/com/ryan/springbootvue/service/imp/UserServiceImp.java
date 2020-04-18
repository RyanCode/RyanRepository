package com.ryan.springbootvue.service.imp;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.User;
import com.ryan.springbootvue.mapper.UserMapper;
import com.ryan.springbootvue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/3/26 20:47
 * version 1.0
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String name, String password) {
        return userMapper.findUser(name,password);
    }

    @Override
    public ResponseDto addUserListData(User user) {
        return null;
    }
}