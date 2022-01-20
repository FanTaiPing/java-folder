package com.cloud.mybatisplus_demo.controller;

import com.cloud.mybatisplus_demo.bean.SysUser;
import com.cloud.mybatisplus_demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/getUser")
    public SysUser getUser(){
        return userService.getById(2);
    }

    @GetMapping("/findAllUser")
    public List<SysUser> findAllUser(){
        return userService.findAllUser();
    }
}

