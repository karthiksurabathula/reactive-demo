package com.reactive.demo.exception;

public class InputValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String message = "Allowed input values are between 10 and 30";;

	private int errorCode;
	private int input;

	public InputValidationException(int errorCode, int input) {
		super(message);
		this.errorCode = errorCode;
		this.input = input;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public int getInput() {
		return input;
	}
}
