package com.asiainfo.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication  
@EnableDiscoveryClient
@EnableJpaAuditing
@ComponentScan(basePackages={"com.asiainfo.sc"}) 
//@EnableJpaRepositories("com.asiainfo.sc.entity")

public class DemoApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	  

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);
    }
	
}
