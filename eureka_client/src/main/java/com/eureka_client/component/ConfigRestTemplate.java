package com.eureka_client.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConfigRestTemplate {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
