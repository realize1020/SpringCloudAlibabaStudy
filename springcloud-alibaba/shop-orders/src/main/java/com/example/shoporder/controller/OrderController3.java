package com.example.shoporder.controller;

import com.example.common.entity.Product;
import com.example.shoporder.service.OrderService;
import com.example.shoporder.service.ProductService;
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



    @RequestMapping("/order/message1")
    public String message1(){
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2(){
        return "message2";
    }
}
