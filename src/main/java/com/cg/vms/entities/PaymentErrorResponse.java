package com.cg.vms.entities;

public class PaymentErrorResponse {
	private int status;
	private String message;
	private long timeStamp;

	// constructors
	public PaymentErrorResponse() {
	}

	public PaymentErrorResponse(int status, String message, long timeStamp) {

		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	// getters and setters

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

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	// to string()
	@Override
	public String toString() {
		return "PaymentErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

}
