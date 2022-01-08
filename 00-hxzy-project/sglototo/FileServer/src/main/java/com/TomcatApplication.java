package com;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * 打 war 包，发布到外置tomcat
 * @author zx
 * @Company ydtf
 * @date 2020/7/6 10:23
 */
public class TomcatApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FileApplication.class);
    }

}