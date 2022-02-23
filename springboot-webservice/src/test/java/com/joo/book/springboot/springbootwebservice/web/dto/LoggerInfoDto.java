package com.joo.book.springboot.springbootwebservice.web.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoggerInfoDto {
	
	List<String> levels;
	Map<String, LoggerInstance> loggers;

}
