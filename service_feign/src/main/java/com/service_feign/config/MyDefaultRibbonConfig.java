package com.service_feign.config;

import com.netflix.loadbalancer.IRule;
import com.service_feign.component.MyRibbonRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDefaultRibbonConfig {
    @Bean
    public IRule ribbonRule(){
        return new MyRibbonRule();
    }
}
