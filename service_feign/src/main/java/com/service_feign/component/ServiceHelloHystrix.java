package com.service_feign.component;

import com.service_feign.service.ServiceHello;
import org.springframework.stereotype.Component;

/**
 * Created by houwanfei on 2017/9/6.
 */
@Component
public class ServiceHelloHystrix implements ServiceHello{
    @Override
    public String sayHello(String name) {
        return "Sorry " + name;
    }
}
