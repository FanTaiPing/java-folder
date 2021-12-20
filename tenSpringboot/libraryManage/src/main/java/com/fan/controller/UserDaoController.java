package com.fan.controller;

import com.fan.entity.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserDaoController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(User user, Model model) {
        User login = userService.login(user);
        if (login != null) {
            if (!user.getName().equals(login.getName())) {
                model.addAttribute("msg", "此用户不存在，请重新输入！");

            }else {
                if(!user.getPassword().equals(login.getPassword())){
                    model.addAttribute("msg","密码错误！");
                }
            }
            return "redirect:/book/findAllBook";
        }else{
            return "/login";
        }
    }
}
