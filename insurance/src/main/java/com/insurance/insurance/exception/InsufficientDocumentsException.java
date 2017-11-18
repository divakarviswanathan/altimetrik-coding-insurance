package com.insurance.insurance.exception;

public class InsufficientDocumentsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientDocumentsException() {
		super("Pl provide valid documents");
	}

	public InsufficientDocumentsException(String arg0) {
		super(arg0);
	}

}
