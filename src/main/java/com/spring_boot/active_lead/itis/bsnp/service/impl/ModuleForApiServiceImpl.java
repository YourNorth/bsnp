package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.setting.client.ModuleForApi;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleForApiService;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ModuleForApiServiceImpl implements ModuleForApiService {

    /*@Autowired
    ModuleSettingService moduleSettingService;

    @Override
    public ModuleForApi getModuleForApi(Module module) {
        try {
            ModuleForApi moduleForApi = new ModuleForApi(module, moduleSettingService.deserializeSettings(module.getSettings()));
            log.info("IN getModuleForApi - module: {}, moduleForApi: {}", module, moduleForApi);
            return moduleForApi;
        } catch (JsonProcessingException e) {
            log.warn("getModuleForApi - module: {}, moduleForApi deserialization is impossible", module);
            return null; //fixme i don`t now what it should return
        }
    }*/
}
