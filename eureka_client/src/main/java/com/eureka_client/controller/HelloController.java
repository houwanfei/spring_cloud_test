package com.eureka_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by houwanfei on 2017/9/6.
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(String name){
        return "Hello " + name + "!"+ port;
    }
}
