package com.fan.service.impl;

import com.fan.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author y
 */
@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public void demo() {
        System.out.println("demoService ok");
    }
}
