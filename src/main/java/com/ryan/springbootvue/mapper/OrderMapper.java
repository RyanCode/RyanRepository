package com.ryan.springbootvue.mapper;

import com.ryan.springbootvue.entity.T_order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/3/29 17:11
 * version 1.0
 */
@Mapper
public interface OrderMapper {
    List<T_order> findList(int from, int to);

    int findAllList();

    List<T_order> findListByStr(String query, int from, int to);

    Integer addOrder(T_order order);

}
