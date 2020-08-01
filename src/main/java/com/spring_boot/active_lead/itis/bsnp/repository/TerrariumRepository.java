package com.spring_boot.active_lead.itis.bsnp.repository;

import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerrariumRepository  extends JpaRepository<Terrarium, Long> {
    List<Terrarium> findAllByUser(User user);
}
