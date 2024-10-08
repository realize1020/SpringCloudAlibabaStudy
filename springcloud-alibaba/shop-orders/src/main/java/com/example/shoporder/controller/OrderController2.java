package com.example.shoporder.controller;

import com.example.common.entity.Product;
import com.example.shoporder.entity.Order;
import com.example.shoporder.service.OrderService;
import com.example.shoporder.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
@RequestMapping("/OrderController2")
public class OrderController2 {
    private final OrderService orderService;

    private final ProductService productService;

    private final ObjectMapper objectMapper;

    private final RocketMQTemplate rocketMQTemplate;

    private final RabbitTemplate rabbitTemplate;


    @RequestMapping("/order/prod/{id}")
    public Product order(@PathVariable("id") Integer id) throws JsonProcessingException {
       log.info("接收到{}号商品的下单请求，接下来调用商品微服务来查询此商品",id);

        //通过restTemplate调用商品微服务
        Product product=productService.findByPid(id);
        log.info("查询到{}号的商品的信息，内容是:{}",id, objectMapper.writeValueAsString(product));

        //模拟一次网络延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //省略订单的有关操作，直接返回商品信息
        return product;
    }


    @RequestMapping("/order/message")
    public String message(){
        return "高并发下的问题测试";
    }


    @RequestMapping("/order2/prod/{id}")
    public Order order2(@PathVariable("id") Integer id) throws JsonProcessingException {
        log.info("接收到{}号商品的下单请求，接下来调用商品微服务来查询此商品",id);

        //通过restTemplate调用商品微服务
        Product product=productService.findByPid(id);
        if (product == null){
            Order order = new Order();
            order.setMemberUsername("下单失败");
            return order;
        }
        log.info("查询到{}号的商品的信息，内容是:{}",id, objectMapper.writeValueAsString(product));
        //模拟一次网络延时
        Order order = new Order();
        order.setId(1);
        order.setMemberUsername("下单成功");
        order.setMemberId(123);
        orderService.save(order);

        //下单成功之后,将消息放到mq中
        rocketMQTemplate.convertAndSend("order-topic", order);

        return order;
    }


    @RequestMapping("/order3/prod/{id}")
    public Order order3(@PathVariable("id") Integer id) throws JsonProcessingException {
        log.info("接收到{}号商品的下单请求，接下来调用商品微服务来查询此商品",id);

        //通过restTemplate调用商品微服务
        Product product=productService.findByPid(id);
        if (product == null){
            Order order = new Order();
            order.setMemberUsername("下单失败");
            return order;
        }
        log.info("查询到{}号的商品的信息，内容是:{}",id, objectMapper.writeValueAsString(product));
        //模拟一次网络延时
        Order order = new Order();
        order.setId(1);
        order.setMemberUsername("下单成功");
        order.setMemberId(123);
        orderService.save(order);

        //下单成功之后,将消息放到mq中
        rabbitTemplate.convertAndSend("OrderDirectExchange", "OrderDirectRounting",order.toString());

        return order;
    }
}
