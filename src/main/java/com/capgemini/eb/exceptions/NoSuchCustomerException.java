package com.capgemini.eb.exceptions;

public class NoSuchCustomerException extends Exception {
	private String message;
	public NoSuchCustomerException(String message) {
		super(message);
	}
}
