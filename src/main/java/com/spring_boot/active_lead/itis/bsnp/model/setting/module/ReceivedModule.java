package com.spring_boot.active_lead.itis.bsnp.model.setting.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceivedModule {
    private int type;
    private String name;
    private ModuleParameter[] params;
}


/*
	{
		"type":1,
		"name":"fish", //адресное имя это 4 байта. я их храню в виде чаров
		"params" :
		[

		]
	}
*/