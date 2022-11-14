package com.capgemini.eb.exceptions;

public class InvalidLoginCredentialException extends Exception {
	private String message;
	public InvalidLoginCredentialException(String message) {
		super(message);
	}
}
