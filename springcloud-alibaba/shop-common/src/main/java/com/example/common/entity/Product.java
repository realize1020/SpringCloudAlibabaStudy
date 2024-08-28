package com.example.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/*
 *@Author wang
 *@Date 2022/7/7 19 :10
 *@description
 */
@TableName("pms_product")
@Data
public class Product {
    private Integer id;

    private String name;

    private Double price;

    private Integer stock; //库存
}
