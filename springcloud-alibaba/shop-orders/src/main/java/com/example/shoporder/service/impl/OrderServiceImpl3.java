package com.example.shoporder.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/*
 *@Author wang
 *@Date 2022/8/25 16 :02
 *@description
 */
@Service
public class OrderServiceImpl3 {

    @SentinelResource("message")

    public void message(){
        System.out.println("message");
    }
}
