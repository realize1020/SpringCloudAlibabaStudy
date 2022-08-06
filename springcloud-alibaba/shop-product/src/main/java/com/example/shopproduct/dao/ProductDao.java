package com.example.shopproduct.dao;

import com.example.common.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *@Author wang
 *@Date 2022/7/11 22 :56
 *@description
 */
@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

}
