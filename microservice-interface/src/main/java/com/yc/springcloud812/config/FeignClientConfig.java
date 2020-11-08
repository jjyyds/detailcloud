package com.yc.springcloud812.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Feign的配置类  关于feign客户端的所有的配置
@Configuration
public class FeignClientConfig {
    //加入安全配置
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("admin","a");
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
