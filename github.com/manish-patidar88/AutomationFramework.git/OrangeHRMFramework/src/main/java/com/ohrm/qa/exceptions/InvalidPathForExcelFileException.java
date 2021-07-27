package com.ohrm.qa.exceptions;

@SuppressWarnings("serial")
public class InvalidPathForExcelFileException extends InvalidPathForFileException {

	public InvalidPathForExcelFileException(String message) {
		super(message);
	}

	public InvalidPathForExcelFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
