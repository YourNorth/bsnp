package com.spring_boot.active_lead.itis.bsnp.controller;

import com.spring_boot.active_lead.itis.bsnp.exception.NotFoundException;
import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Terrarium;
import com.spring_boot.active_lead.itis.bsnp.model.User;
import com.spring_boot.active_lead.itis.bsnp.security.UserDetailsImpl;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleService;
import com.spring_boot.active_lead.itis.bsnp.service.TerrariumService;
import com.spring_boot.active_lead.itis.bsnp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/terrarium")
@Slf4j
public class TerrariumController {

    @Autowired
    ModuleService moduleService;

    @Autowired
    TerrariumService terrariumService;

    @GetMapping
    public List<Terrarium> getAll(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return terrariumService.findAllByUser(userDetails.getUser());
    }

    @GetMapping("{id}")
    public  Terrarium getOne(@PathVariable String id){
        Long number = null;
        try {
            number = Long.parseLong(id);
            Optional<Terrarium> terrarium = terrariumService.findById(number);
            if (terrarium.isPresent()) {
                log.info(terrarium.toString());
                return terrarium.get();
            }
        } catch (NumberFormatException e) {
            log.info("Illegal argument, message of exception: {}", e.getMessage());
        }
        throw new NotFoundException();
    }

    @GetMapping("{id}/modules")
    public  List<Module> getModulesByTerrariumId(@PathVariable String id){
        Long number = null;
        try {
            number = Long.parseLong(id);
            Optional<Terrarium> terrarium = terrariumService.findById(number);
            if (terrarium.isPresent()) {
                List<Module> modules = moduleService.findAllByTerrarium(terrarium.get());
                log.info("IN getModulesByTerrariumId - terrarium: {} by id: {} and modules: {}", terrarium, number, modules);
                return modules;
            }
        } catch (NumberFormatException e) {
            log.info("IN getModulesByTerrariumId - Illegal argument, message of exception: {}", e.getMessage());
        }
        throw new NotFoundException();
    }

    @PostMapping
    public Terrarium createAndUpdateTerrarium(@RequestBody Terrarium terrarium){
        return terrariumService.save(terrarium);
    }}
