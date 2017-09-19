package com.eureka_miya.eureka_miya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/miya")
    public String info(){
        return restTemplate.getForObject("http://localhost:8762/info",String.class);
    }

    @RequestMapping(value = "/hi")
    public String home(){
        return "hi i'm miya!";
    }
}
