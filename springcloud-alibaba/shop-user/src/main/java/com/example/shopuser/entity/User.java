package com.example.shopuser.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/*
 *@Author wang
 *@Date 2022/7/7 18 :58
 *@description
 */

//使用mall的数据库来测试
@TableName("ums_member")
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String phone;
}
