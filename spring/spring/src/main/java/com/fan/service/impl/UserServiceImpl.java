package com.fan.service.impl;

import com.fan.dao.UserDao;
import com.fan.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @author y
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    private String name;
    private int age;
    private Date bir;
    private double money;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    //注入数组
    private String[] items;

    public void setItems(String[] items) {
        this.items = items;
    }

    //注入集合
    private List list;

    public void setList(List list) {
        this.list = list;
    }

    //构造方法注入
    private int id;

    public UserServiceImpl(int id) {
        this.id = id;
    }

    //构造数组注入
    private String[] arr;

    public UserServiceImpl(int id,String[] arr) {
        this.id = id;
        this.arr = arr;
    }

    @Override
    public void save(String name) {
        userDao.save("地方撒地方");
        System.out.println("UserService:" + name);
        System.out.println("打印输出内容：" + this.name);
        System.out.println("年龄：" + age);
        System.out.println("生日：" + bir);
        System.out.println("金钱：" + money);
        //数组注入打印
        for (String item : items) {
            System.out.println(item);
        }
        //list集合注入打印
        list.forEach(System.out::println);

        //构造注入打印
        System.out.println("构造注入的id是：" + id);
        for(String arrs:arr){
            System.out.println(arrs);
        }
    }
}
