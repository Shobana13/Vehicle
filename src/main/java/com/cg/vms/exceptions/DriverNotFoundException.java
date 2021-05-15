package com.cg.vms.exceptions;

public class DriverNotFoundException extends RuntimeException {

	public DriverNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DriverNotFoundException(String message) {
		super(message);
	}

	public DriverNotFoundException(Throwable cause) {
		super(cause);
	}
}
