package com.spring_boot.active_lead.itis.bsnp.controller;

import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.setting.client.ModuleForApi;
import com.spring_boot.active_lead.itis.bsnp.model.setting.module.Answer;
import com.spring_boot.active_lead.itis.bsnp.model.setting.module.ReceivedModule;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleForApiService;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ControlController {

    @Autowired
    ModuleService moduleService;

    @Autowired
    ModuleForApiService moduleForApiService;

    @PostMapping("/control")
    public Answer[] postSettings(@RequestBody ReceivedModule[] modules){
        List<Answer> answers = new LinkedList<>();
        log.info("IN postSettings - modules are {}", modules);
        /*for (int i = 0; i < modules.length; i++) {
            Optional<Module> module = moduleService.findByAddress(modules[i].getName());
            if(module.isPresent()){
                ModuleForApi moduleForApi = moduleForApiService.getModuleForApi(module.get());
                moduleForApi.getEditableParameters().get
            }
        }*/
        return null; //fixme
    }
}
