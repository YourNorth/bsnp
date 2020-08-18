package com.spring_boot.active_lead.itis.bsnp.dto.device.response;

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

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDeviceModelDto {

    @JsonIgnore
    @Autowired
    ModuleService moduleService;

    @JsonIgnore
    Module module;

    private String address;

    private List<ResponseDeviceParameterDto> settings;

}
