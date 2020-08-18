package com.spring_boot.active_lead.itis.bsnp.dto.device.request;

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

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDeviceModuleDto {

    @JsonIgnore
    @Autowired
    ModuleService moduleService;

    @JsonIgnore
    Module module;

    private int type;

    private String name;

    private List<RequestDeviceParameterDto> params;

    RequestDeviceModuleDto(long id){
        Optional<Module> moduleFromDB = moduleService.findById(id);
        if( moduleFromDB.isPresent()){
            log.info("IN constructor DeviceModuleDto - id : {}, module from DB: {}", id, moduleFromDB );
            new RequestDeviceModuleDto(moduleFromDB.get());
        }
        else{
            log.info("IN constructor DeviceModuleDto - id : {} is not correct", id );
            throw new IllegalArgumentException("id is not correct");
        }
    }

    public RequestDeviceModuleDto(Module module) {
        this.module = module;
        this.name = module.getAddress();
        this.type = module.getModuleType();
        params = new LinkedList<>();
        for(Parameter parameter : module.getParameters()){
            params.add(RequestDeviceParameterDto.builder()
                    .code(parameter.getCode())
                    .real_value(parameter.getRealValue())
                    .set_value(parameter.getSetValue())
                    .build());
        }
        log.info("IN constructor DeviceModuleDto - module from DB: {}, module for device: {}", module, this);
    }
}
