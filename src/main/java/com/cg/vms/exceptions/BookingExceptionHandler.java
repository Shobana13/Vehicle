package com.cg.vms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.vms.entities.BookingErrorResponse;

@ControllerAdvice
public class BookingExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BookingErrorResponse> handleException(BookingNotFoundException exception) {
		BookingErrorResponse error = new BookingErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<BookingErrorResponse> handleException(Exception exception) {
		BookingErrorResponse error = new BookingErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
