package com.example.shopuser.rocketmq;

import com.alibaba.fastjson.JSON;
import com.example.common.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//发送短信的服务
@Slf4j
@Service
@RabbitListener(queues="OrderDirectQueue")
public class SmsService2 {

    @RabbitHandler
    public void process(String orderMessage){
        System.out.println("Order消费者收到消息："+orderMessage);
    }
}
