package com.ryan.springbootvue.mapper;

import com.ryan.springbootvue.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/3/15 12:08
 * version 1.0
 */
@Mapper
public interface BookMapper {
    int insert(Book book);

    int insertSelective(Book record);

    List<Book> findList(Book book);
}
