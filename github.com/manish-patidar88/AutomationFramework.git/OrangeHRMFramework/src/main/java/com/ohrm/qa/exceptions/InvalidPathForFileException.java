package com.ohrm.qa.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForFileException extends FrameworkException {

	public InvalidPathForFileException(String message) {
		super(message);
	}

	public InvalidPathForFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
