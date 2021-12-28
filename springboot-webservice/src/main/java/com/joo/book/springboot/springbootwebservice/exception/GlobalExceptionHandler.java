package com.joo.book.springboot.springbootwebservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<?> handleIllegalArguException(IllegalArgumentException e) {

		return new ResponseEntity<>(
				new ResponseError().setDetails(e.getLocalizedMessage()).setTimestamp(LocalDateTime.now()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
