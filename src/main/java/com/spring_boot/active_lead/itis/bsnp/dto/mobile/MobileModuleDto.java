package com.spring_boot.active_lead.itis.bsnp.dto.mobile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_boot.active_lead.itis.bsnp.model.Module;
import com.spring_boot.active_lead.itis.bsnp.model.Parameter;
import com.spring_boot.active_lead.itis.bsnp.service.ModuleService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class MobileModuleDto {

    @JsonIgnore
    @Autowired
    ModuleService moduleService;

    @JsonIgnore
    private Module module;

    Long id;

    String name;

    List<MobileParameterDto> uneditableParameters;

    List<MobileParameterDto> editableParameters;

    MobileModuleDto(long id){
        Optional<Module> moduleFromDB = moduleService.findById(id);
        if( moduleFromDB.isPresent()){
            log.info("IN constructor MobileModuleDto - id : {}, module from DB: {}", id, moduleFromDB );
            new MobileModuleDto(moduleFromDB.get());
        }
        else{
            log.info("IN constructor MobileModuleDto - id : {} is not correct", id );
            throw new IllegalArgumentException("id is not correct");
        }
    }

    public MobileModuleDto(Module module){
        this.module = module;
        this.id = module.getId();
        this.name = module.getName();
        this.editableParameters = new LinkedList<>();
        this.uneditableParameters = new LinkedList<>();
        for (Parameter parameter : module.getParameters()){
            editableParameters.add(MobileParameterDto
                    .builder()
                    .name(parameter.getName())
                    .value(parameter.getSetValue())
                    .build());
            uneditableParameters.add(MobileParameterDto
                    .builder()
                    .name(parameter.getName())
                    .value(parameter.getRealValue())
                    .build());
        }
        log.info("IN MobileModuleDto - dto: {}", this);
    }

}
