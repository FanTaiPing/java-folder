package com.km.sglototo.component;

import com.km.sglototo.vo.OssAliyunField;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OssAliyunConfig {

    @Bean(value = "defaultOssAliyunField")
    @ConfigurationProperties("oss.aliyun.defalut")
    public OssAliyunField defaultOssAliyunField() {
        return new OssAliyunField();
    }

    @Bean(value = "firstOssAliyuField")
    @ConfigurationProperties("oss.aliyun.first")
    public OssAliyunField firstOssAliyuField() {
        return new OssAliyunField();
    }

    @Bean(value = "secondOssAliyuField")
    @ConfigurationProperties("oss.aliyun.second")
    public OssAliyunField secondOssAliyuField() {
        return new OssAliyunField();
    }
}
