package com.lftechnology.module.api.exception;


public class ApiResponseException extends Exception {
    public ApiResponseException() {
        super("Fail request data from api");
    }

    public ApiResponseException(String message) {
        super(message);
    }
}
