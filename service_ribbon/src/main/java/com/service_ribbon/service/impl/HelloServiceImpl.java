package com.service_ribbon.service.impl;

import com.service_ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by houwanfei on 2017/9/6.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String syaHello(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name="+name, String.class);
    }
}
