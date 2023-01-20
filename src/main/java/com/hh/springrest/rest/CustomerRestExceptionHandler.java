package com.hh.springrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

//	add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
//		create CustomerErrorResponse
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setTimeStamp(System.currentTimeMillis());
//		return ResponseEntity
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

//	add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {
//		create CustomerErrorResponse
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimeStamp(System.currentTimeMillis());
//		return ResponseEntity
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
