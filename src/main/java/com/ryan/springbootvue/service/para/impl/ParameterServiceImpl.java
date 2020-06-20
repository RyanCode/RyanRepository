package com.ryan.springbootvue.service.para.impl;

import com.ryan.springbootvue.dto.ParameterDto;
import com.ryan.springbootvue.entity.Parameter;
import com.ryan.springbootvue.mapper.PublicMapper;
import com.ryan.springbootvue.service.para.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author Ryan
 * @Date 2020/6/6 18:01
 * version 1.0
 */
@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private PublicMapper publicMapper;

    public static Predicate<Parameter> predicate_point= s->s.getId()!=null;
    @Override
    public ParameterDto findAll() {
        //对数据库日期格式数据格式化
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Parameter> list=publicMapper.getPara();
        //转stream流
        List<String> collect = list.stream()
                .filter(predicate_point)
                .map(s-> sdf.format(s.getDate()))
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(list);
        return ParameterDto.getInstance().succ(list);
    }

    @Override
    public ParameterDto findById(int id) {
        Parameter parameter= publicMapper.getParaById(id);
        return ParameterDto.getInstance().succ(parameter);
    }
}
