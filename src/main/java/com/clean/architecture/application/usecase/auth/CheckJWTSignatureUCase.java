package com.clean.architecture.application.usecase.auth;

import org.springframework.security.access.AccessDeniedException;

public interface CheckJWTSignatureUCase {
    void checkSignature(String token) throws AccessDeniedException;
}
