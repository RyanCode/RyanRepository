package com.ryan.springbootvue.service;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.Book;

/**
 * @Author Ryan
 * @Date 2020/3/15 12:12
 * version 1.0
 */
public interface BookService {
    ResponseDto findBookListData(Book book);

    ResponseDto addBookData(Book book);
}
