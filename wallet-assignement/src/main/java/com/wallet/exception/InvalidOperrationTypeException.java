package com.wallet.exception;

public class InvalidOperrationTypeException extends RuntimeException{

	String exceptionMessage;
	
	public InvalidOperrationTypeException(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
}
