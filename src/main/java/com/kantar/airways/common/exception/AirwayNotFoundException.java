package com.kantar.airways.common.exception;

public class AirwayNotFoundException extends RuntimeException {
	private String message = "Not found";

	public AirwayNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
