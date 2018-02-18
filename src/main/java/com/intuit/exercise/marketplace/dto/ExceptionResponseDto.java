package com.intuit.exercise.marketplace.dto;

public class ExceptionResponseDto {
	
	public ExceptionResponseDto(String errorMessage) {
		this.errorMessage=errorMessage;
		
	}
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
