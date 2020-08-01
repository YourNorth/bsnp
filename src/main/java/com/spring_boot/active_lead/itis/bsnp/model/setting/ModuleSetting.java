package com.spring_boot.active_lead.itis.bsnp.model.setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleSetting {
        List<Parameter> uneditableParameters;

        List<Parameter> editableParameters;
}
