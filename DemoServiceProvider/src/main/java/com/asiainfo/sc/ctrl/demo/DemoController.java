package com.asiainfo.sc.ctrl.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.sc.entity.Account;
import com.asiainfo.sc.svc.demo.DemoService;


@RestController
public class DemoController {

	
	@Autowired
	@Qualifier("DemoService")
    private DemoService demoService;
    
	@Value("${server.port}")
    private int serverPort = 0;

	
//	@Autowired
//    public DemoServiceCtrl(DemoService demoService) {
//        this.demoService = demoService;
//    }
// 
	 @RequestMapping(value = "/api/demoService/{name}", method = RequestMethod.GET)
	 public ResponseEntity getUserAccount(@PathVariable("name") String name) throws Exception {
		   
		System.out.println("name="+name); 
        return Optional.ofNullable(demoService.getUserAccounts(name))
                .map(a -> new ResponseEntity<List<Account>>(a, HttpStatus.OK))
                .orElseThrow(() -> new Exception("Accounts for user do not exist"));
    }
    
   
	
	
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @GetMapping("instance-info")
    public List<ServiceInstance> showInfo(){
    	
    	return this.discoveryClient.getInstances("DEMO-SERVICE");
    	
    	
    }
    
	
}
