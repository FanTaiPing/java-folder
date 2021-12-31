package com.fan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 首页控制器
 * @author y
 * @Controller(告诉spring一个控制器)
 */
@Controller
public class IndexController {
    /**
     * RequestMapping 请求映射路径（包含所有请求）
     * 修饰范围：用在类和方法上
     * 给当前方法加入一个统一的请求路径
     *注意：类上和方法上同时使用@RequestMapping()时，请求路径必须是/类上路径/方法路径
     * @return jsp页面前缀名称
     */
    @RequestMapping("/")
    public String index(){
        //默认转发到index("forward:index),重定向是redirect:/index
        return "index";
    }
}
