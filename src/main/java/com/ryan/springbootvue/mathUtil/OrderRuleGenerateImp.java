package com.ryan.springbootvue.mathUtil;

import com.ryan.springbootvue.entity.T_order;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author Ryan
 * @Date 2020/4/2 16:09
 * version 1.0
 */
@Service
public class OrderRuleGenerateImp implements OrderRuleGenerate{
    /**
     * uuid生成唯一主键
     * @param
     */
    @Override
    public String generateStr(T_order order) {
        String s=UUID.randomUUID().toString();
        return s;
    }
}
