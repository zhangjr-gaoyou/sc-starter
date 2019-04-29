package com.asiainfo.sc.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@EnableEurekaClient
@EnableHystrix
public class UaaServer {

	  public static void main(String[] args) {
	        SpringApplication.run(UaaServer.class, args);
	    }
	  
	  
	  @Component
	  public class CustomizedRestMvcConfig extends RepositoryRestConfigurerAdapter {

	      @Override
	      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	          config.setBasePath("/api");
	      }
	  }
	  
}
