package com.asiainfo.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "DEMO-SERVICE", configuration = RibbonConfiguration.class)
public class ServiceRibbonConfig {

}
