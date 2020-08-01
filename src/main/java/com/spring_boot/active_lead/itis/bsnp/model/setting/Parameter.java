package com.spring_boot.active_lead.itis.bsnp.model.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parameter {
    private String name;
    private String value;
}
