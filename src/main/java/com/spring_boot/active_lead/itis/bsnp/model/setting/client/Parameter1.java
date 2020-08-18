package com.spring_boot.active_lead.itis.bsnp.model.setting.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parameter1 {
    private String name;
    private String value;
}
