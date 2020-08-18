package com.spring_boot.active_lead.itis.bsnp.controller;

import com.spring_boot.active_lead.itis.bsnp.dto.mobile.MobileModuleDto;
import com.spring_boot.active_lead.itis.bsnp.exception.NotFoundException;
import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.setting.client.ModuleForApi;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleForApiService;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/module")
@Slf4j
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @Autowired
    ModuleForApiService moduleForApiService;

    @GetMapping()
    public List<Module> getAll() {
        return moduleService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("{id}")
    public MobileModuleDto getOne(@PathVariable String id) {
        Long number = null;
        try {
            number = Long.parseLong(id);
            Optional<Module> module = moduleService.findById(number);
            if (module.isPresent()) {
                log.info(module.toString());
                return new MobileModuleDto(module.get());
            }
        } catch (NumberFormatException e) {
            log.info("Illegal argument, message of exception: {}", e.getMessage());
        }
        throw new NotFoundException();
        /* Long number;
        try {
            number = Long.parseLong(id);
            Optional<Module> module = moduleService.findById(number);
            if (module.isPresent()) {
                ModuleForApi moduleForApi = moduleForApiService.getModuleForApi(module.get());
                log.info("IN getOne - module: {}, moduleForApi: {}", module, moduleForApi);
                return moduleForApi;
            }
        } catch (NumberFormatException e) {
            log.info("Illegal argument, message of exception: {}", e.getMessage());
        }
        throw new NotFoundException();*/
        /*Long number = null;
        try {
            number = Long.parseLong(id);
            Optional<Module> module = moduleService.findById(number);
            if (module.isPresent()) {
                log.info(module.toString());
                return module.get();
            }
        } catch (NumberFormatException e) {
            log.info("Illegal argument, message of exception: {}", e.getMessage());
        }
        throw new NotFoundException();*/
    }

    @PostMapping
    public Module createAndUpdateModule(@RequestBody Module module){
        return moduleService.save(module);
    }

}
