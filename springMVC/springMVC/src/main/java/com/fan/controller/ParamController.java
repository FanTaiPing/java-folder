package com.fan.controller;

import com.fan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 参数控制器
 * @author y
 * @Contorller+@ResponseBody合起来的注解相当于@RestController
 */
@Controller
@RequestMapping("param")
public class ParamController {

    /**
     * @param id
     * @param name
     * @return
     * @GetMapping Get请求路径
     * @ResponseBody 用在类上和方法上，返回的是自动转换好的JSON对象或XML对象(Ajax请求是必须加)
     * @RequestParam 请求参数时：单参数时可不加，多参数必须加
     * <p>
     * CrossOrigin  跨域处理  可以用来类或方法上
     */
    @GetMapping("getParam")
    @ResponseBody
    public String testPet(@RequestParam("id") int id, @RequestParam("name") String name, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id + "\nname:" + name);
        String str = "id:" + id + "\nname:" + name;
        //response.setContentType("text/html;charset=UTF-8");
        return str;
    }


    @RequestMapping("paramUser")
    public String testPost() {

        return "postForm";
    }

    /**
     * 模拟前端 对象 提交
     *
     * @param user
     * @RequestBody:前端请求体 (一般用于Ajax里的JSON对象)
     * PsotMapping Post 请求路径
     */
    @GetMapping("postUser")
    @ResponseBody
    public User testPost(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @PostMapping("getUser")
    @ResponseBody
    public User testGetUser(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
