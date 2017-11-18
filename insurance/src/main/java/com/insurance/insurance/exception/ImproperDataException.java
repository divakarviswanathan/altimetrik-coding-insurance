package com.insurance.insurance.exception;

public class ImproperDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImproperDataException() {
		super("Pl check the data entered");
	}

	public ImproperDataException(String arg0) {
		super(arg0);
	}

}
