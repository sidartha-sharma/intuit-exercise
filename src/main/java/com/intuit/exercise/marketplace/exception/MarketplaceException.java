package com.intuit.exercise.marketplace.exception;

public class MarketplaceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MarketplaceException(String message) {
		
		this.message=message;
		
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
