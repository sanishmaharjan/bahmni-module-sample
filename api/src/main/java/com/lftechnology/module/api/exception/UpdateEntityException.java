package com.lftechnology.module.api.exception;

public class UpdateEntityException extends Exception {
    public UpdateEntityException() {
        super("Failed to update Entity");
    }

    public UpdateEntityException(String message) {
        super(message);
    }
}
