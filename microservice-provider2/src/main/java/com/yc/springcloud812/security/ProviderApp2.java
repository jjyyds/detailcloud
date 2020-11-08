package com.yc.springcloud812.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //启用服务发现客户端，以获取当前provider的注册信息
public class ProviderApp2 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp2.class,args);
    }
}
