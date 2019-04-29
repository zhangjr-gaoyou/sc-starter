package com.asiainfo.sc.feign.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "DEMO-SERVICE", url = "http://localhost:8040/demo", fallback = DemoFeignZuulClientFallback.class)
public interface DemoFeignZuul {
	@RequestMapping(value = "/api/demoService/{name}", method = RequestMethod.GET)
	public String getFoo(@PathVariable("name") String name);

}

@Component
class DemoFeignZuulClientFallback implements DemoFeignZuul {
	@Override
	public String getFoo(@PathVariable("name") String name) {
		return "Resp from zuul feign fallback." + name;
	}
}