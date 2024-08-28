package com.example.shopproduct.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.common.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/*
 *@Author wang
 *@Date 2022/7/11 22 :56
 *@description
 */
@Mapper
public interface ProductDao extends BaseMapper<Product> {

}
