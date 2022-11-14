package com.capgemini.eb.exceptions;

public class NoSuchEmailException extends Exception {
	private String message;
	public NoSuchEmailException(String message) {
		super(message);
	}
}
