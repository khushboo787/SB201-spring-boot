package com.masaischool.B28_SB201_Ex_24.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String uri;

	public ErrorDetails(LocalDateTime timestamp, String message, String uri) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.uri = uri;
	}

	//keep the getter methods as they are required to convert in JSON object
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getUri() {
		return uri;
	}
}
