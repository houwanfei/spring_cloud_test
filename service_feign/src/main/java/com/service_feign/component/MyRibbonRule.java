package com.service_feign.component;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.List;
import java.util.Map;

public class MyRibbonRule extends ZoneAvoidanceRule {
    @Override
    public Server choose(Object key) {
        System.out.println("MyRule choose " + key + " ... ");
        List<Server> serverList = this.getPredicate()
                .getEligibleServers(this.getLoadBalancer().getAllServers(), key);
        for (Server server : serverList){
            Map<String, String> metadata = ((DiscoveryEnabledServer)server).getInstanceInfo().getMetadata();
            System.out.println();
        }
        return super.choose(key);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        System.out.println("MyRule setLoadBalancer  ... ");
        super.setLoadBalancer(lb);
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        System.out.println("MyRule getLoadBalancer  ... ");
        return super.getLoadBalancer();
    }
}
