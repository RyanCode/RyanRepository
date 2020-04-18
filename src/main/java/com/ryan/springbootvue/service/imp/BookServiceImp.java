package com.ryan.springbootvue.service.imp;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.Book;
import com.ryan.springbootvue.mapper.BookMapper;
import com.ryan.springbootvue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/3/15 12:14
 * version 1.0
 */
@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public ResponseDto findBookListData(Book books) {
        List<Book> list=bookMapper.findList(books);
        return ResponseDto.instance().ok(list,new Integer(0));
    }

    @Override
    public ResponseDto addBookData(Book books) {
        int i=bookMapper.insertSelective(books);
        return ResponseDto.instance().ok(i,new Integer(0));
    }
}
