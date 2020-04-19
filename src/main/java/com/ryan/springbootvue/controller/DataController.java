package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.T_order;
import com.ryan.springbootvue.service.order.OrderRuleGenerate;
import com.ryan.springbootvue.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @Author Ryan
 * @Date 2020/3/29 19:48
 * version 1.0
 */
@RestController
public class DataController {
    @Autowired
    private OrderRuleGenerate orderRuleGenerate;
    @Autowired
    private OrderService orderService;
    @CrossOrigin
    @GetMapping("/order")
    public ResponseDto getOrderListBySize(@RequestParam String query, Integer pageNum, Integer pageSize){
        int from=pageNum*pageSize-pageSize;
        int to=pageSize;
        return query.equals("") ? orderService.findOrderList(from,to):orderService.findOrderListStr(query,from,to);
    }


    @PostMapping(value = "/addOrder")
    @ResponseBody
    public int addOrderList(@RequestBody T_order order) throws ParseException {
        order.setId(orderRuleGenerate.generateStr(order));
        return orderService.addOrderList(order);
    }
}
