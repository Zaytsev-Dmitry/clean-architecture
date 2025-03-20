package com.clean.architecture.domain.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String error;

    public NotFoundException(final String error) {
        super(error);
        this.error = error;
    }
}
