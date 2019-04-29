package com.asiainfo.sc.base.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiainfo.sc.base.entity.User;
import com.asiainfo.sc.base.repo.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HystrixCommand
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}