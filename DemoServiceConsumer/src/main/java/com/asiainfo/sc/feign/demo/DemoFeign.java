package com.asiainfo.sc.feign.demo;

/**
 * 使用feign 声明式服务调用
 */
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "DEMO-SERVICE",fallback = DemoFeignClientFallback.class)
public interface DemoFeign {
  @RequestMapping(value = "/api/demoService/{name}", method = RequestMethod.GET)
  public String getFoo(@PathVariable("name") String name);
}

@Component
class DemoFeignClientFallback implements DemoFeign {
  @Override
  public String getFoo(@PathVariable("name") String name) {    
    return "Resp from feign fallback."+name;
  }
} 