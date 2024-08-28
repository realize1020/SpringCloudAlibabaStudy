package com.example.shopproduct.controller;

import com.example.common.entity.Product;
import com.example.shopproduct.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


/*
 *@Author wang
 *@Date 2022/7/7 20 :51
 *@description
 */
//@RefreshScope
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${test.fileName}")
    private String fileName;

    @GetMapping("/product/{id}")
    public Product product(@PathVariable("id") Integer id){
        Product product=productService.findById(id);
        log.info("查询商品："+(product));
        return product;
    }
    @GetMapping("/fileName")
    public String getFileName(){
        return fileName;
    }
}
