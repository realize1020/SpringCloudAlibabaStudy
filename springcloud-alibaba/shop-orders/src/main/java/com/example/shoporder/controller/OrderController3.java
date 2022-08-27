package com.example.shoporder.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.common.entity.Product;
import com.example.shoporder.service.OrderService;
import com.example.shoporder.service.ProductService;
import com.example.shoporder.service.impl.OrderServiceImpl3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@Author wang
 *@Date 2022/7/20 09 :58
 *@description
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/OrderController3")
public class OrderController3 {
    private final OrderService orderService;

    private final ProductService productService;

    private final ObjectMapper objectMapper;

    private final OrderServiceImpl3 orderServiceImpl3;



    @RequestMapping("/order/message1")
    public String message1(){

        orderServiceImpl3.message();
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2(){
        orderServiceImpl3.message();
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3")//必须使用这个注解，否则热点规则不生效
    public String message3(String name,Integer age){
        return name+age;
    }

    //授权规则
    @RequestMapping("/order/message4")
    @SentinelResource("message4")//必须使用这个注解，否则热点规则不生效
    public String message4(){
        return "message4";
    }
}
