package com.spring_boot.active_lead.itis.bsnp.dto.device.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDeviceParameterDto {

    private int code;

    private float set_value;

    private float real_value;

}
