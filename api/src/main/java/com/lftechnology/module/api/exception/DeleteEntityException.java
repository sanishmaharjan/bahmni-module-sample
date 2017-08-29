package com.lftechnology.module.api.exception;

public class DeleteEntityException extends Exception {
    public DeleteEntityException() {
        super("Fail to delete Entity");
    }

    public DeleteEntityException(String message) {
        super(message);
    }
}
