package com.asiainfo.sc.demo;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;



@SpringBootApplication
//@EnableOAuth2Client
@EnableOAuth2Sso
//@EnableResourceServer

public class UaaClientApplication extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(UaaClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UaaClientApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/client/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
    
    
//    @Bean
//    public OAuth2RestTemplate restTemplate(
//            OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
//        return new OAuth2RestTemplate(resource, context);
//    }
    

}