package com.spring_boot.active_lead.itis.bsnp.service;

import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.setting.ModuleForApi;
import org.springframework.stereotype.Service;

@Service
public interface ModuleForApiService {
    public ModuleForApi getModuleForApi(Module module);
}
