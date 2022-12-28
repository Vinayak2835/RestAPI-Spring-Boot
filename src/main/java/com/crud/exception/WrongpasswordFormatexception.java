package com.crud.exception;

public class WrongpasswordFormatexception extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public WrongpasswordFormatexception() {
		super();
	}
	
	public WrongpasswordFormatexception(String message) {
		super(message);
	}

}
