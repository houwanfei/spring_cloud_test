package com.service_feign.service;

import com.service_feign.component.ServiceHelloHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by houwanfei on 2017/9/6.
 */
@FeignClient(value = "eureka-client", fallback = ServiceHelloHystrix.class)
public interface ServiceHello {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name);
}
