package com.example.shopproduct.service.impl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.entity.Product;
import com.example.shopproduct.dao.ProductDao;
import com.example.shopproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 *@Author wang
 *@Date 2022/7/7 20 :46
 *@description
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao,Product> implements ProductService{

    @Resource
    private ProductDao productDao;

    public Product findById(Integer id){
        return productDao.selectById(id);
    }
}
