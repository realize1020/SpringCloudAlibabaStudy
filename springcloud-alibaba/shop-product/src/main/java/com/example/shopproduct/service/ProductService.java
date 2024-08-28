package com.example.shopproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.entity.Product;

/*
 *@Author wang
 *@Date 2022/7/7 20 :46
 *@description
 */
public interface ProductService extends IService<Product> {
    Product findById(Integer id);
}
