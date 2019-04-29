package com.asiainfo.sc.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication

public class EurekaServerApplication {

	public static void main(String[] args) {
		// if you want to deplay tomcat server  
		//new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run( args);
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	
//	@EnableWebSecurity
//	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	    	
//	        http.csrf().ignoringAntMatchers("/eureka/**");
//	        super.configure(http);
//	    }
//	}
	
}