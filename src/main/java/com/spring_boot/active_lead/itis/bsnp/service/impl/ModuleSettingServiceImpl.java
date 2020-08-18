package com.spring_boot.active_lead.itis.bsnp.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_boot.active_lead.itis.bsnp.model.setting.client.ModuleSetting;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ModuleSettingServiceImpl implements ModuleSettingService {

    @Override
    public ModuleSetting deserializeSettings(String settings) throws JsonProcessingException {
        ModuleSetting result = new ObjectMapper().readValue(settings, ModuleSetting.class);
        log.info("IN deserializeSettings - settings: {}, moduleSetting: {}", settings, result);
        return result;
    }

    @Override
    public String serializeSettings(ModuleSetting moduleSetting) throws JsonProcessingException {
        String result = new ObjectMapper().writeValueAsString(moduleSetting);
        log.info("IN serializeSettings - moduleSettings: {}, json: {}", moduleSetting, result);
        return result;
    }
}
