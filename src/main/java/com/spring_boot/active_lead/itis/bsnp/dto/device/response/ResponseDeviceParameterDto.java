package com.spring_boot.active_lead.itis.bsnp.dto.device.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_boot.active_lead.itis.bsnp.model.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDeviceParameterDto {

    @JsonIgnore
    private Parameter parameter;

    private int code;

    private float set_value;
}
