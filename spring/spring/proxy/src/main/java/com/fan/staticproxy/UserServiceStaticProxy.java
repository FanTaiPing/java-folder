package com.fan.staticproxy;

import com.fan.service.UserService;

/**
 * 注意：这里为每一个业务层通过手动开发一个代理对象的过程称之为  静态代理对象
 * 代理对象
 * @author y
 */
public class UserServiceStaticProxy implements UserService {

    //依赖注入原始业务逻辑对象
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void save(String name) {
        try {
            System.out.println("开启事务");
            //调用原始业务逻辑对象的方法
            userService.save(name);
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            System.out.println("开启事务");
            //调用原始业务逻辑对象的方法
            userService.delete(id);
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try {
            System.out.println("开启事务");
            //调用原始业务逻辑对象的方法
            userService.update();
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
    }

    @Override
    public String findAll(String name) {
        try {
            System.out.println("开启事务");
            //调用原始业务逻辑对象的方法
            String all = userService.findAll(name);
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String findOne(String id) {
        try {
            System.out.println("开启事务");
            //调用原始业务逻辑对象的方法
          String one =  userService.findOne(id);
            System.out.println("提交事务");
        }catch (Exception e){
            System.out.println("回滚事务");
            e.printStackTrace();
        }
        return null;
    }
}
