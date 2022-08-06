package com.example.common.entity;

import lombok.Data;

import javax.persistence.*;

/*
 *@Author wang
 *@Date 2022/7/7 19 :10
 *@description
 */
@Entity(name="Product")
@Table(name="pms_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    private Integer stock; //库存
}
