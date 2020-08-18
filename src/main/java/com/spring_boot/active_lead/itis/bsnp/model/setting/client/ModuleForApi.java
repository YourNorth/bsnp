package com.spring_boot.active_lead.itis.bsnp.model.setting.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_boot.active_lead.itis.bsnp.model.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleForApi {
    @JsonIgnore
    private Module module;

    @JsonIgnore
    private ModuleSetting moduleSetting;

    private Long id;

    private String name;

    private List<Parameter> uneditableParameters;

    private List<Parameter> editableParameters;

    public ModuleForApi(Module module, ModuleSetting moduleSetting) {
        this.module = module;
        this.moduleSetting = moduleSetting;
        this.id = module.getId();
        this.name = module.getName();
        this.editableParameters = moduleSetting.editableParameters;
        this.uneditableParameters = moduleSetting.uneditableParameters;
    }
}
