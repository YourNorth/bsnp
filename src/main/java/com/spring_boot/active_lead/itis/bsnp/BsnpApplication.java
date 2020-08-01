package com.spring_boot.active_lead.itis.bsnp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BsnpApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsnpApplication.class, args);
    }
}