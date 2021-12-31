package com.fan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("city")
@CrossOrigin //解决跨域问题
public class WeatherController {
    @GetMapping("find")
    public Map<String, String> findWeather(String name) {
        Map<String, String> map = new HashMap<String, String>(16);
        String weather = getWeather(name);
        map.put("message", weather);
        return map;
    }

    public String getWeather(String name) {
        Map<String, String> map = new HashMap<String, String>(16);
        map.put("北京", "阴,空气质量差");
        map.put("上海", "晴,空气质量一般");
        map.put("广东", "多云, 空气质量良好");
        map.put("深圳", "多云转晴, 空气质量一般");
        map.put("杭州", "晴, 空气质量良好");
        return map.get(name);
    }
}
