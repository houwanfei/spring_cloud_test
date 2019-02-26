package com.eureka_client.controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by houwanfei on 2017/9/6.
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(String name){
        return "Hello " + name + "!"+ port;
    }

    @RequestMapping(value = "/hi")
    public String callHome(){
        return restTemplate.getForObject("http://localhost:8998/miya", String.class);
    }

    @RequestMapping(value = "/info")
    public String info(){
        return "hi, i'm eureka_client";
    }
}
