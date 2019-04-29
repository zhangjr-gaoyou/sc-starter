package com.asiainfo.sc.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.asiainfo.sc.filter.DemoFilter;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages={"com.asiainfo.sc"}) 

public class ZuulGateway {
	public static void main(String[] args) {
	    SpringApplication.run(ZuulGateway.class, args);
	  }
	
	@Bean
	  public DemoFilter demoFilter() {
	    return new DemoFilter();
	  }
}
