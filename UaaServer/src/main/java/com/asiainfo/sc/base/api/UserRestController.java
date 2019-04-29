package com.asiainfo.sc.base.api;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.sc.base.entity.User;



@RestController
@RequestMapping(path = "/v1")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/me")
    public ResponseEntity me(Principal principal) {
        User user = null;
        if(principal != null) {
            user = userService.getUserByUsername(principal.getName());
        }

        return Optional.ofNullable(user)
                .map(a -> new ResponseEntity<User>(a, HttpStatus.OK))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
