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

@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 注入UserService
     */
    @Autowired
    private UserService userService;
    /**
     * 注入EmpService
     */
    @Autowired
    private EmpService empService;


    /**
     * 调用登录查询方法判断所登录的用户是否存在于数据库中
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.login(username, password);
        if (user == null) {
            //登录失败，重定向到登录页面
            return "redirect:/";
        }
        //登录成功，重定向到后台EmpList.jsp页面刷新首页数据
//        return "redirect:pages/EmpList";
        //重新封装刷新首页数据的方法
        return "redirect:/user/empFindAll";
    }

    @GetMapping("empFindAll")
    public String empFindAll(Model model) {
        List<Emp> empList = empService.findAll();
        if(empList == null){
            return "redirect:/";
        }
        model.addAttribute("empList",empList);
        return "pages/empList";
    }
}
