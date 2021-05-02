package com.reactive.demo.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.reactive.demo.exception.InputValidationException;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(InputValidationException.class)
	public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException ex) {
		InputFailedValidationResponse response = new InputFailedValidationResponse();
		response.setErrorCode(ex.getErrorCode());
		response.setInput(ex.getInput());
		response.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<InputFailedValidationResponse> handleException(Exception ex) {
		InputFailedValidationResponse response = new InputFailedValidationResponse();
		response.setErrorCode(0);
		response.setInput(0);
		response.setMessage("System exception");
		return ResponseEntity.badRequest().body(response);
	}

}
