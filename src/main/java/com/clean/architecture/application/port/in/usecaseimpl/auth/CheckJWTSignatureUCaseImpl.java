package com.clean.architecture.application.port.in.usecaseimpl.auth;

import com.clean.architecture.adapters.AppSettings;
import com.clean.architecture.application.port.out.rest.keycloak.KeycloakClient;
import com.clean.architecture.application.port.out.rest.keycloak.request.IntrospectTokenRequest;
import com.clean.architecture.application.port.out.rest.keycloak.response.IntrospectTokenResponse;
import com.clean.architecture.application.usecase.auth.CheckJWTSignatureUCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckJWTSignatureUCaseImpl implements CheckJWTSignatureUCase {
    private final KeycloakClient keycloakClient;
    private final AppSettings settings;

    @Override
    public void checkSignature(final String token) throws AccessDeniedException {
        IntrospectTokenResponse introspect = keycloakClient.introspect(new IntrospectTokenRequest(settings, token));
        if (!introspect.isActive()) {
            throw new AccessDeniedException("Access denied. introspect is false");
        }
    }
}
