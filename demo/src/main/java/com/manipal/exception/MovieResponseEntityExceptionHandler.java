package com.manipal.exception;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MovieResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {	
	
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<ExceptionResponse> movieNotFound(MovieNotFoundException exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	
	}
	
	
/*	@ExceptionHandler(ProducerNotFoundException.class)
	public ResponseEntity<ExceptionResponse> producerNotFound(ProducerNotFoundException exception) {
		ExceptionResponse response = new ExceptionResponse(exception.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	
	}
	*/
	
	
	
}
