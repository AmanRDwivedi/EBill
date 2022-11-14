package com.capgemini.eb.exceptions;

public class NoSuchConnectionException extends Exception {
	private String message;
	public NoSuchConnectionException(String message) {
		super(message);
	}
}
