package com.fan.controller;

import com.fan.entity.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(User user) {
        User login = userService.login(user.getUsername(), user.getPassword());
        if (login == null) {
            //登录失败跳回登录页面
            return "redirect:/user/login";
        }
        //登录成功，跳转到查询员工所有信息界面
        return "redirect:/emp/empFindAll";
    }
}
