package com.joo.book.springboot.springbootwebservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoggerInstance {
	String configuredLevel;
	String effectiveLevel;
}
