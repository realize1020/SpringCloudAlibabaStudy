package com.example.shopproduct.service.impl;
import com.example.common.entity.Product;
import com.example.shopproduct.dao.ProductDao;
import com.example.shopproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@Author wang
 *@Date 2022/7/7 20 :46
 *@description
 */

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    public Product findById(Integer id){
        return productDao.findById(id).get();
    }
}
