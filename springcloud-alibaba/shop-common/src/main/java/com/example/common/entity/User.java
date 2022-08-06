package com.example.common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *@Author wang
 *@Date 2022/7/7 18 :58
 *@description
 */

//使用mall的数据库来测试
@Entity(name="ums_member")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String phone;
}
