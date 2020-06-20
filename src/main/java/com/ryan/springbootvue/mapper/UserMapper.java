package com.ryan.springbootvue.mapper;

import com.ryan.springbootvue.entity.Journals;
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


    User findUser(String name, String password);

    Boolean judgeIsAdmin(String userName);

    int insertJournal(Journals journals);

    List<Journals> findAllJournal();

    List<User> findAllUser();

    int deleteUser(String name);


}
