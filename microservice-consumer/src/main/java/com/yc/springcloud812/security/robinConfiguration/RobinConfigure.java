package com.yc.springcloud812.security.robinConfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

//这个类暂时不会被spring托管
public class RobinConfigure {
    @Bean
    public IRule ribbonRule(){ //其中IRule就是所有规则的标准
        return new RandomRule(); //随机的访问策略
    }
}
