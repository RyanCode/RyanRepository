package com.ryan.springbootvue.mapper;

import com.ryan.springbootvue.entity.Parameter;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/6/6 17:56
 * version 1.0
 */
public interface PublicMapper {
    List<Parameter> getPara();

    Parameter getParaById(int id);

    //public

    


}
