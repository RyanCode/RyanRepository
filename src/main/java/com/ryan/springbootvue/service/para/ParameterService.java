package com.ryan.springbootvue.service.para;

import com.ryan.springbootvue.dto.ParameterDto;

/**
 * @Author Ryan
 * @Date 2020/6/6 18:01
 * version 1.0
 */
public interface ParameterService {
    ParameterDto findAll();

    ParameterDto findById(int id);
}
