package com.exapmple.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);

        // 获取当前时间
        ZonedDateTime now = ZonedDateTime.now();

        // 或者设置一个特定的时间，例如2024年的今天
        ZonedDateTime specificDate = ZonedDateTime.of(2024, now.getMonthValue(), now.getDayOfMonth(), 14, 50, 0, 0, now.getZone());

        // 使用ISO 8601格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        String formattedTime = specificDate.format(formatter);

        // 输出时间字符串
        System.out.println("Formatted time: " + formattedTime);
    }
}
