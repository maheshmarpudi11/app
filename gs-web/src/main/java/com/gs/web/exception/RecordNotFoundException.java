package com.gs.web.exception;

public class RecordNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public String message;
	
	public RecordNotFoundException(){
		super();
	}
	
	public RecordNotFoundException(String message){
		super(message);
	}
}
