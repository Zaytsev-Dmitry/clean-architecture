package com.clean.architecture.application.port.in.usecaseimpl.auth;

import com.clean.architecture.application.port.out.rest.keycloak.KeycloakClient;
import com.clean.architecture.application.port.out.rest.keycloak.response.UserInfoResponse;
import com.clean.architecture.application.usecase.auth.AuthenticationUCase;
import com.clean.architecture.domain.auth.CleanArchitectureUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class AuthenticationUCaseImpl implements AuthenticationUCase {
    private final KeycloakClient keycloakClient;

    @Override
    public UserDetails authenticate(final String token) {
        try {
            UserInfoResponse userInfo = keycloakClient.getUserInfo("Bearer " + token);
            return new CleanArchitectureUserDetails(userInfo);
        } catch (Exception e) {
            throw new AccessDeniedException(String.format("invalid token: %s", e.getMessage()), e);
        }
    }
}
