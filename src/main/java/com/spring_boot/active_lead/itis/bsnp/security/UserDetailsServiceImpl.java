package com.spring_boot.active_lead.itis.bsnp.security;

import com.spring_boot.active_lead.itis.bsnp.model.User;
import com.spring_boot.active_lead.itis.bsnp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> result = userService.findByLogin(login);
        if(result.isPresent()){
            return new UserDetailsImpl(result.get());
        }
        else {
            log.warn("IN loadByUsername - user with name {} was not founded",login);
            throw new UsernameNotFoundException("user was not founded");
        }
    }
}
