package com.spring_boot.active_lead.itis.bsnp.controller;

import com.spring_boot.active_lead.itis.bsnp.model.User;
import com.spring_boot.active_lead.itis.bsnp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user_test")
public class UserTestControtroller {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> addUser(){
        Random random = new Random();
        User user = User.builder()
                .login(String.valueOf(random.nextInt()))
                .password(String.valueOf(random.nextInt()))
                .build();
        userRepository.save(user);
        return userRepository.findAll();
    }
}
