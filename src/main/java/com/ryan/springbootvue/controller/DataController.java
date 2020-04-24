package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.T_order;
import com.ryan.springbootvue.mathUtil.RSA;
import com.ryan.springbootvue.service.order.OrderRuleGenerate;
import com.ryan.springbootvue.service.order.OrderService;
import com.ryan.springbootvue.service.token.GenAndVerTokenService;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    private GenAndVerTokenService genAndVerTokenService;
    @Autowired
    private UserService userService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/order")
    @ResponseBody
    public ResponseDto getOrderListBySize(@RequestParam String query, Integer pageNum, Integer pageSize){
        int from=pageNum*pageSize-pageSize;
        int to=pageSize;
        return query.equals("") ? orderService.findOrderList(from,to):orderService.findOrderListStr(query,from,to);
    }

    @PostMapping(value = "/addOrder")
    @ResponseBody
    @CrossOrigin
    public int addOrderList(@RequestBody T_order order) {
        order.setId(orderRuleGenerate.generateStr(order));
        return orderService.addOrderList(order);
    }

    @GetMapping("/user/isAdmin")
    @ResponseBody
    @CrossOrigin
    public Boolean isAdmin(HttpServletRequest request) throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String account = RSA.decrypt(token, genAndVerTokenService.PRIVATE_KEY).split(" ")[0];
        return userService.isAdmin(account);
    }
}
