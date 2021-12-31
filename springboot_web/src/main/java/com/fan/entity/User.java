package com.fan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data                       //代表一个实体类，自动生成getter/setter方法的注解
@NoArgsConstructor          // 无参构造方法
@AllArgsConstructor         // 带所有属性的构造方法
@ToString                   //生成重写Object的toString方法
@Accessors(chain = true)    // 生成链式调用
public class User {
    private int id;
    private String username;
    private String password;
}
