package com.spring_boot.active_lead.itis.bsnp.controller;

import com.spring_boot.active_lead.itis.bsnp.exception.NotFoundException;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import com.spring_boot.active_lead.itis.bsnp.repository.UserRepository;
import com.spring_boot.active_lead.itis.bsnp.service.TerrariumService;
import com.spring_boot.active_lead.itis.bsnp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();
        log.info("users: {}",users.toString());
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable String id) {
        Long number = null;
        try {
            number = Long.parseLong(id);
            Optional<User> user = userService.findById(number);
            if (user.isPresent()) {
                log.info(user.toString());
                return user.get();
            }
        } catch (NumberFormatException e) {
            log.info("Illegal argument, message of exception: {}", e.getMessage());
        }
        throw new NotFoundException();
    }

    @PostMapping
    public User createAndUpdateUser(@RequestBody User user){
        return userService.save(user);
    }
}
