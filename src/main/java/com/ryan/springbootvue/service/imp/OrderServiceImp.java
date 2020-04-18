package com.ryan.springbootvue.service.imp;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.T_order;
import com.ryan.springbootvue.mapper.OrderMapper;
import com.ryan.springbootvue.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/3/29 17:17
 * version 1.0
 */
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseDto findOrderList(int from,int to) {
        List<T_order> list=orderMapper.findList(from,to);
        Integer num=orderMapper.findAllList();
        return ResponseDto.instance().ok(list,num);
    }

    @Override
    public ResponseDto findOrderListStr(String query, int from, int to) {
        List<T_order> list=orderMapper.findListByStr(query,from,to);
        Integer num=orderMapper.findAllList();
        return ResponseDto.instance().ok(list,num);
    }

    @Override
    public int addOrderList(T_order order) {
        return orderMapper.addOrder(order);
    }
}
