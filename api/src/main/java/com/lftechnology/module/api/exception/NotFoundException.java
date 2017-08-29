package com.lftechnology.module.api.exception;


public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
        super("Entity not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
