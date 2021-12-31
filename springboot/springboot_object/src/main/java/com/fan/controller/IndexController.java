package com.fan.controller;

import com.fan.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @author y
 */
//@Controller
//@ResponseBody
@RestController
public class IndexController {
    /**
     * @Autowired 默认自动根据类型注入
     * 改成自动根据名称注入
     */
    @Autowired
    private DemoService demoService;
    //@Qualifier(value = "demoService")
//    private DemoService demoService;
    @Autowired
    private Calendar calendar;

    @Value("${ftpimg.realUrl}")
    private String imgUrl;

    @RequestMapping("/")
    public String hello() {
        System.out.println("Hello springBoot");
        return "hello";
    }

    @GetMapping("demo")
    public String demoService() {
        System.out.println("demo ok");
        demoService.demo();
        return "demo ok";
    }

    @GetMapping("calendar")
    public String demoCalendar() {
        System.out.println("读出配置文件里的url:" + imgUrl);
        System.out.println(calendar.getTime());
        return "当前是今年的第" + calendar.getWeekYear() + "个星期";
    }
}
