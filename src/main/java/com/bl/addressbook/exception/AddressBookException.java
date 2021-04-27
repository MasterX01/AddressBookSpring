package com.bl.addressbook.exception;


public class AddressBookException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public final exceptionType type;
	public enum exceptionType{
		CONTACT_NOT_FOUND
	}
	
	public AddressBookException(exceptionType exception, String message) {
		super(message);
		this.type = exception;
	}

}
