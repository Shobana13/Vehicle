package com.cg.vms.entities;

public class CustomerErrorResponse {

	private int status;
	private String message;
	private long timestamp;

	// Constructors
	public CustomerErrorResponse() {
	}

	public CustomerErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	// Getters and setters
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
