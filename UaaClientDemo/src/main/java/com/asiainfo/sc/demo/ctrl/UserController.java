package com.asiainfo.sc.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
class UserController {

//    @Autowired
//    private OAuth2RestOperations restTemplate;

   
//    @RequestMapping("/")
//    public JsonNode home() {
//        return restTemplate.getForObject(resourceURI, JsonNode.class);
//    }

//    public String  home() {
//      return restTemplate.getForEntity("http://localhost:8181/api/uaa/v1/me",String.class).getBody();
//   }
    
    @RequestMapping("/hi")
    public String hello() {
        //return restTemplate.getForObject(resourceURI+"/hello", String.class);
        return "hello! world!";
    }

}