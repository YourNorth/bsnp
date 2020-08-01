package com.spring_boot.active_lead.itis.bsnp.service;

import com.spring_boot.active_lead.itis.bsnp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends SuperService<User, Long> {
    User register(User user);
    @Override
    public Optional<User> findById(Long id);
    @Override
    public List<User> findAll();
    @Override
    public User save(User user);
    @Override
    public void delete(User user);

    Optional<User> findByLogin(String login);
}
