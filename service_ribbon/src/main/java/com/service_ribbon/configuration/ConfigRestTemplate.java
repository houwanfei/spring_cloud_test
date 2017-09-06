package com.service_ribbon.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by houwanfei on 2017/9/6.
 */
@Configurable
public class ConfigRestTemplate {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
