package com.spring_boot.active_lead.itis.bsnp.model.setting.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleParameter {
    private int code;
    private int set_value;
    private int real_value;
}

/*
{
"code":12,
"set_value":144444,
"real_value":12222
}
*/