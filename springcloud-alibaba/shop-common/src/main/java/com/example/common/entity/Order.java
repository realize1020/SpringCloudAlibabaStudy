package com.example.common.entity;

import lombok.Data;



@Data
public class Order {


    private Integer id;

    private Integer memberId;

    private String memberUsername;
}
