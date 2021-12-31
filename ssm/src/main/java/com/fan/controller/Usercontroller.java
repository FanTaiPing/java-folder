package com.fan.controller;

import com.fan.entity.Emp;
import com.fan.entity.User;
import com.fan.service.EmpService;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * 用户表操作控制器
 * @author y
 */
@Controller
@RequestMapping("user")
public class Usercontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private EmpService empService;

    /**
     * 用户登录方法
     * @param username
     * @param password
     * @param model
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userService.login(username, password);
        if (user == null) {
            //model.addAttribute("msg","用户名或密码错误！！");
            return "redirect:/index";
        }
        //登录成功
        //跳转到empList页面
        return "redirect:/user/empFindAll";
    }

    /**
     * 查询所有员工方法  用户登录成功之后跳转到的界面刷新数据是调用的方法
     * @param model
     */
    @GetMapping("empFindAll")
    public String empFindAll(Model model){
        //调用查询所有员工列表
        List<Emp> empList = empService.findAll();
        model.addAttribute("empList",empList);
        return "pages/empList";
    }
}
