package com.yc.springcloud812.security;

import com.yc.springcloud812.security.robinConfiguration.RobinConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient    //启用eureka客户端，这样能完成服务发现
//指定这个新的负载均衡算法类给MICROSERVICE-PROVIDER这个服务用
//这里的name指服务器的名称，如果需要有多个服务提供方，这个时候可以使用@RibbonClients进行配置
//只对服务名为MICROSERVICE-PROVIDER下的服务清单采用RobinConfigure指定的随机负载均衡方式
//如有多个服务要用不同的策略，则采用@RibbonClients
@RibbonClient(name="MICROSERVICE-PROVIDER",configuration = RobinConfigure.class)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}
