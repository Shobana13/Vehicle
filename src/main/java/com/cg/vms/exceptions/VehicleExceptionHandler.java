package com.cg.vms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.vms.entities.VehicleErrorResponse;

@ControllerAdvice
public class VehicleExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<VehicleErrorResponse> handleException(VehicleNotFoundException exception) {
		VehicleErrorResponse error = new VehicleErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<VehicleErrorResponse> handleException(Exception exception) {
		VehicleErrorResponse error = new VehicleErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}