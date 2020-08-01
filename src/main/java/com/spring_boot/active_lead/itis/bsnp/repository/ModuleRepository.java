package com.spring_boot.active_lead.itis.bsnp.repository;

import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findAllByTerrarium(Terrarium terrarium);
}
