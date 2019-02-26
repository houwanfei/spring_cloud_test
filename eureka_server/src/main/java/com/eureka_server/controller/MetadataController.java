package com.eureka_server.controller;

import com.eureka_server.controller.mo.MetadataMO;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.eureka.registry.InstanceRegistry;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @outhor ikan
 * @create 2019-02-26 9:16
 */
@RestController
@RequestMapping("api/eureka/metadate")
public class MetadataController {
    @Autowired
    private PeerAwareInstanceRegistry instanceRegistry;

    @PostMapping("update")
    public void updateMetadata(@RequestBody MetadataMO metadataMO){
        InstanceInfo instanceInfo = instanceRegistry.getInstanceByAppAndId("EUREKA-CLIENT", "localhost:eureka-client:8762");

        if (instanceInfo ==  null){
            return;
        }

        Map<String, String> metadataMap = instanceInfo.getMetadata();
        metadataMap.put(metadataMO.getKey(), metadataMO.getValue());
        instanceRegistry.register(instanceInfo, false);
    }

//    public List<InstanceInfo> getMetadata(String id){
//        return discoveryClient.getInstancesById(id);
//    }
}