package com.asiainfo.sc.ctrl.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.asiainfo.sc.feign.demo.DemoFeign;
import com.asiainfo.sc.feign.demo.DemoFeignZuul;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ch.qos.logback.classic.Logger;


@Controller
@RefreshScope

public class DemoClientCtrl {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DemoClientCtrl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {

			return "index";

	}

	
	
	
	// eureka服务器
	
	@HystrixCommand(fallbackMethod = "getFooFallback")
	@RequestMapping(value = "/demo/{name}", method = RequestMethod.GET)
	public String getFoo(Model model, @PathVariable("name") String name) {

		try {
			String resp = restTemplate.getForEntity("http://DEMO-SERVICE/api/demoService/" + name, String.class)
					.getBody();

			model.addAttribute("respData", resp);
		} catch (Exception e) {

			model.addAttribute("respData", e.toString());
		}
		return "foo";

	}
	
	

	public String getFooFallback(Model model,@PathVariable("name") String name) {
		
		String mesg = new String();
		mesg = "Now,Fallback Return."+name;
		model.addAttribute("respData", JSON.toJSONString(mesg));
        return "foo";
    }
	
	
	 /**
     * 使用声明式服务调用
     */
    
	
	 @Autowired
	 private DemoFeign demoFeign;
	 
	 @RequestMapping(value = "/demofeign/{name}", method = RequestMethod.GET)
	 public String getFeignFoo(Model model, @PathVariable("name") String name) {
		 
		 try {
				String resp = this.demoFeign.getFoo(name);

				model.addAttribute("respData", resp + "by feign");
			} catch (Exception e) {

				model.addAttribute("respData", e.toString());
			}
			return "foo";

			
	 }
	 
	 
	 /**
	     * 使用声明式服务通过Zuul调用
	     */
	    
		
		 @Autowired
		 private DemoFeignZuul demoFeignZuul;
		 
		 @RequestMapping(value = "/demozuul/{name}", method = RequestMethod.GET)
		 public String getZuulFoo(Model model, @PathVariable("name") String name) {
			 
			 try {
					String resp = this.demoFeignZuul.getFoo(name);

					model.addAttribute("respData", resp + " by zuul - feign");
				} catch (Exception e) {

					model.addAttribute("respData", e.toString());
				}
				return "foo";

				
		 }
		 
	 
	 @GetMapping("/log-user-instance")
	  public void logUserInstance() {
	    ServiceInstance serviceInstance = this.loadBalancerClient.choose("DEMO-SERVICE");
	    // 打印当前选择的是哪个节点
	    DemoClientCtrl.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
	  }
	 

}
