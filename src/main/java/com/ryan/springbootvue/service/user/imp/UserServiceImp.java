package com.ryan.springbootvue.service.user.imp;

import com.ryan.springbootvue.dto.ParameterDto;
import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.Journals;
import com.ryan.springbootvue.entity.User;
import com.ryan.springbootvue.mapper.UserMapper;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean isAdmin(String userName) {
        return userMapper.judgeIsAdmin(userName);
    }

    @Override
    public int insertJournal(Journals journals) {
        return userMapper.insertJournal(journals);
    }

    @Override
    public ParameterDto findAllJournal() {
        return ParameterDto.getInstance().succ(userMapper.findAllJournal());
    }

    @Override
    public ResponseDto findUser() {
        return ResponseDto.instance().ok(userMapper.findAllUser());
    }

    @Override
    public int deleteUser(String name) {
        return userMapper.deleteUser(name);
    }


}
