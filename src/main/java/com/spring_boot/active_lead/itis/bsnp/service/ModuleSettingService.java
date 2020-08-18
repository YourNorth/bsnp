package com.spring_boot.active_lead.itis.bsnp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring_boot.active_lead.itis.bsnp.model.setting.client.ModuleSetting;
import org.springframework.stereotype.Service;

@Service
public interface ModuleSettingService {
    public ModuleSetting deserializeSettings(String settings) throws JsonProcessingException;

    String serializeSettings(ModuleSetting moduleSetting) throws JsonProcessingException;
}
