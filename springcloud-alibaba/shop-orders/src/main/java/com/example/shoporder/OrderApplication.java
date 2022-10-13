package com.example.shoporder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 *@Author wang
 *@Date 2022/7/11 22 :52
 *@description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//开启Fegin
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }


    //Ribbon均衡负载
    //经过多次分析发现，如果使用nacos自定义的均衡负载的话，就不要用ribbion的均衡负载和@LoadBalanced。
    // 增加@LoadBalanced，就不能使用127.0.0.1,
    // 只能使用应用名(等于上图的fqyd-member不区分大小写),
    //@LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
