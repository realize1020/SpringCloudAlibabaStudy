package com.example.shoporder.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *@Author wang
 *@Date 2022/7/7 19 :15
 *@description
 */
@Entity(name="oms_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer memberId;

    private String memberUsername;
}
