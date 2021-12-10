package com.gs.web.exception;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> handleConnectionException(RecordNotFoundException ex){
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<Object> handleConnectionException(){
		
		return new ResponseEntity<Object>("third-party services is down..",HttpStatus.NOT_FOUND
				
				);
	}	
}
