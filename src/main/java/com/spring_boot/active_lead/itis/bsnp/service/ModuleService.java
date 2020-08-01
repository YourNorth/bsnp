package com.spring_boot.active_lead.itis.bsnp.service;

import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ModuleService extends SuperService<Module, Long> {
    @Override
    public Optional<Module> findById(Long id);

    @Override
    public List<Module> findAll();

    @Override
    public Module save(Module module);

    @Override
    public void delete(Module module);

    public List<Module> findAllByTerrarium(Terrarium terrarium);
}
