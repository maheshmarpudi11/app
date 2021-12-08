package com.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);

		});

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorDetails(errors);
		errorResponse.setStatusCode("400");
		errorResponse.setError("Validation failed");

		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ RecordNotFoundException.class })
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex,
			WebRequest request) {

		ErrorResponse errorRes = new ErrorResponse();
		errorRes.setError(ex.getMessage());
		errorRes.setErrorDetails(ex.getLocalizedMessage());
		errorRes.setStatusCode("404");

		return new ResponseEntity<ErrorResponse>(errorRes, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		logger.info("CustomExceptionHandler - > handleAllExceptions");

		ErrorResponse errorRes = new ErrorResponse();
		errorRes.setError(ex.getMessage());
		errorRes.setStatusCode("500");

		return new ResponseEntity<ErrorResponse>(errorRes, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorDetails(ex.getLocalizedMessage());
		errorResponse.setStatusCode("404");
		errorResponse.setError(ex.getMessage());

		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}

	
	