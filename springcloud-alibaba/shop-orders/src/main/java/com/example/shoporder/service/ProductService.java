package com.example.shoporder.service;

import com.example.common.entity.Product;
import com.example.shoporder.service.impl.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 *@Author wang
 *@Date 2022/7/18 19 :49
 *@description
 */
//创建一个service,并使用Fegin实现微服务调用,//fallback用于指定容错类
@FeignClient(value = "shop-product",fallback = ProductServiceFallBack.class)//声明调用提供者的name
public interface ProductService {
    //指定调用提供者的哪个方法
    //@FeignClient+@GetMapping就是一个完整的请求路径 http://shop-product/product/{pid}


    @GetMapping(value="/product/{id}")
    Product findByPid(@PathVariable("id") Integer id);

}
