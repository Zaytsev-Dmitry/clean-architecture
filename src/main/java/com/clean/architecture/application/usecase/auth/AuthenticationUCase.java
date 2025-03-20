package com.clean.architecture.application.usecase.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationUCase {
    UserDetails authenticate(final String token);
}
