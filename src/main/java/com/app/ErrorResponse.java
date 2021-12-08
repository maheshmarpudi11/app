package com.app;

import java.util.Map;

public class ErrorResponse {

	private String statusCode;
	private String error;
	private Object errorDetails;
	
	public ErrorResponse() {
	}
	
	public ErrorResponse(String statusCode, String error, Map errorDetails) {
		this.statusCode = statusCode;
		this.error = error;
		this.errorDetails = errorDetails;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(Object object) {
		this.errorDetails = object;
	}

}
