package com.ryan.springbootvue.service.order;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.T_order;

/**
 * @Author Ryan
 * @Date 2020/3/29 17:14
 * version 1.0
 */
public interface OrderService {
    ResponseDto findOrderList(int pageNum,int pageSize);

    ResponseDto findOrderListStr(String query,int pageNum,int pageSize);

    int addOrderList(T_order order);
}
