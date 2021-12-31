package com.fan.controller;

import com.fan.entity.User;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserDaoController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(User user, Model model, String name, HttpSession session) {
        //判断用户是否存在
        if (userService.isExistsUser(name) != null) {
            User login = userService.login(user);
            if (login != null) {
                if (!user.getPassword().equals(login.getPassword())) {
                    model.addAttribute("msg", "密码错误！");
                    return "login";
                }
                //登录成功，跳转到后台首页刷新数据
                session.setAttribute("user", login.getName());
                return "redirect:/book/findAllBook";
            } else {
                return "/login";
            }
        } else {
            model.addAttribute("msg", "此用户不存在，请重新输入！");
            return "login";
        }
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        return "redirect:/login";
    }
}
