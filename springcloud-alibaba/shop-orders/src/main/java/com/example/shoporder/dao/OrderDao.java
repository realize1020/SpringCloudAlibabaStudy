package com.example.shoporder.dao;

import com.example.shoporder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *@Author wang
 *@Date 2022/7/11 22 :56
 *@description
 */
public interface OrderDao extends JpaRepository<Order,Long>{

}
