package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.spring_boot.active_lead.itis.bsnp.model.Role;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import com.spring_boot.active_lead.itis.bsnp.repository.UserRepository;
import com.spring_boot.active_lead.itis.bsnp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = Role.ROLE_USER;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleUser);
        User registeredUser = save(user);
        log.info("IN REGISTER - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        log.info("IN FINDBYID for USER - optional: {}", result);
        return result;
    }

    @Override
    public List<User> findAll() {

        List<User> result = userRepository.findAll();
        log.info("IN GETALL - {} users found", result.size());
        return result;
    }

    @Override
    public User save(User user) {
        User result = userRepository.save(user);
        log.info("IN SAVE - {} user was saved or updated", result);
        return result;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> result = userRepository.findUserByLogin(login);
        log.info("IN FINDBYLOGIN - optinal: {} witg login: {}", result, login);
        return result;
    }
}
