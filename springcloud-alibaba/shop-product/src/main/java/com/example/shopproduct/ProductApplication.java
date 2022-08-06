package com.example.shopproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 *@Author wang
 *@Date 2022/7/7 20 :03
 *@description
 */
//@ComponentScan(basePackages = "com.example.shopproduct.*.*")
@EnableJpaRepositories(basePackages = "com.example.shopproduct.dao")
@EntityScan("com.example.common.entity")
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
