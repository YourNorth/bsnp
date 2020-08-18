package com.spring_boot.active_lead.itis.bsnp.model.setting.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    private String address;
    private ModuleParameter settings;
}

/*
{
	//передается в качестве параметра, а не как параметр
	//адресное имя модуля
	"address" : "fish",
	//переименовал параметр, если ты не против
	"settings":
	[
		//каждый параметр в качестве объекта
		{"code" : 12, //код параметра
		"set_value":144444, //если пользователь задал какое-то новое значение. иначе по этому модулю ничего не присылать
		},
		{"code" : 7,
		"set_value":-12,
		}
	]
}
*/