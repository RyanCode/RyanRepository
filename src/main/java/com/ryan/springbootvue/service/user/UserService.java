package com.ryan.springbootvue.service.user;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.User;

/**
 * @Author Ryan
 * @Date 2020/3/26 20:44
 * version 1.0
 */
public interface UserService {

    User findUserById(String name,String password);

    ResponseDto addUserListData(User user);

}
