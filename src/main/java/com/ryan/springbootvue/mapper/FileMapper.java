package com.ryan.springbootvue.mapper;

import com.ryan.springbootvue.entity.UserFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/6/9 21:54
 * version 1.0
 */
@Mapper
public interface FileMapper {
    int save(UserFile userFile);

    List<UserFile> getFile();
}
