package com.asiainfo.config;

import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class OurCustomRule implements IRule {

	ILoadBalancer balancer = new BaseLoadBalancer();
	
	@Override
	public Server choose(Object key) {
		List<Server> allServers = balancer.getAllServers();
		// TODO
		return null;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
	
		return this.balancer;
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		
		this.balancer = lb;
		
	}

}
