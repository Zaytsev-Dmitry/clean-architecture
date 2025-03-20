package com.clean.architecture.domain.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private final String error;

    public ValidationException(final String message) {
        super(message);
        this.error = message;
    }
}
