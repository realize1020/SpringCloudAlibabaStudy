package com.example.shopuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 *@Author wang
 *@Date 2022/7/7 19 :22
 *@description
 */
@SpringBootApplication
@EnableDiscoveryClient
//@MapperScan("com.example.shopuser")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
