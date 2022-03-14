package com.dtchin2.passgen.exception;

public class InvalidPasswordLengthException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPasswordLengthException(String message) {
		super(message);
	}
	
	public InvalidPasswordLengthException(String message, Throwable t) {
		super(message, t);
	}

}
