package com.ust.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralisedExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookNotFoundException.class)
	public String bookNotFound(BookNotFoundException e) {
		return e.getMessage();
	}
}
