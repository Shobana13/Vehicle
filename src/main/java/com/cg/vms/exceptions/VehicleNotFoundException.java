package com.cg.vms.exceptions;

public class VehicleNotFoundException extends RuntimeException {

	public VehicleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleNotFoundException(String message) {
		super(message);
	}

	public VehicleNotFoundException(Throwable cause) {
		super(cause);
	}
}
