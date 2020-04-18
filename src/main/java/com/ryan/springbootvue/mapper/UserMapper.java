package com.ryan.springbootvue.mapper;

import com.ryan.springbootvue.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/3/26 20:42
 * version 1.0
 */
@Mapper
public interface UserMapper {

    int insert(User user);

    User findUser(String name, String password);
}
