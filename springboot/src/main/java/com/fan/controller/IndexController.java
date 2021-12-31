package com.fan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author y
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        System.out.println("Hello SpringBoot ======>");
        return "hello";
    }
}
