package com.example.shoporder.service.impl;

import com.example.shoporder.dao.OrderDao;
import com.example.shoporder.entity.Order;
import com.example.shoporder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@Author wang
 *@Date 2022/7/11 23 :02
 *@description
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    public void save(Order order){
        orderDao.save(order);
    }

}
