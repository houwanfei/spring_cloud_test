package com.service_feign.controller;

import com.service_feign.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by houwanfei on 2017/9/6.
 */
@RestController
public class HelloController {
    @Autowired
    private ServiceHello serviceHello;

    @RequestMapping(value = "/hello")
    public String sayHello(String name){
        return serviceHello.sayHello(name);
    }
}
