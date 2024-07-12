package com.example.shoporder.service.impl;

import com.example.common.entity.Product;
import com.example.shoporder.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductServiceFallBack implements ProductService {

    @Override
    public Product findByPid(Integer id) {
        Product product = new Product();
        product.setId(-1);
        return product;
    }
}
