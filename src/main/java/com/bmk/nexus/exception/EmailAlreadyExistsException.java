package com.bmk.nexus.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException (String message) {
        super(message);
    }
}
