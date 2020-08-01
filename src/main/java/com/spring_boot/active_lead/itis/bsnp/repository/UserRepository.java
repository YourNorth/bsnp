package com.spring_boot.active_lead.itis.bsnp.repository;

import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
}
