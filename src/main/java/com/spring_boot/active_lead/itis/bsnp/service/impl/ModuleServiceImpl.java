package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.repository.ModuleRepository;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public Optional<Module> findById(Long id)
    {
        Optional<Module> result = moduleRepository.findById(id);
        log.info("IN findById - id: {}, module:{}", id, result);
        return result;
    }

    @Override
    public List<Module> findAll() {
        List<Module> result = moduleRepository.findAll();
        log.info("IN findAll - count of modules:{}", result.size());
        return result;
    }

    @Override
    public Module save(Module module) {
        Module result = moduleRepository.save(module);
        log.info("IN save - module:{}", module);
        return result;
    }

    @Override
    public void delete(Module module) {

        log.info("IN delete - module: {}", module);moduleRepository.delete(module);
    }

    @Override
    public List<Module> findAllByTerrarium(Terrarium terrarium) {
        List<Module> result = moduleRepository.findAllByTerrarium(terrarium);
        log.info("IN findAllByTerrarium - terrarium: {}, count of models: {}", terrarium, result.size());
        return result;
    }
}