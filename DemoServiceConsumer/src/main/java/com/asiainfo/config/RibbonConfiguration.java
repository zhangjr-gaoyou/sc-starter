package com.asiainfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class RibbonConfiguration {
  @Bean
  public IRule ribbonRule() {
    return new RoundRobinRule();
  }
}
