package com.lftechnology.module.api.exception;

public class SaveEntityException extends Exception {

    private static final long serialVersionUID = 5678642488281077351L;

    public SaveEntityException() {
        super("Failed to save Entity");
    }

    public SaveEntityException(String message) {
        super(message);
    }
}
