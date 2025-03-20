package com.clean.architecture.application.port.out.rest.keycloak.request;

import com.clean.architecture.adapters.AppSettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntrospectTokenRequest {
    private String token;
    private String client_id;
    private String client_secret;
    private String grant_type;

    public IntrospectTokenRequest(final AppSettings settings, final String token) {
        this.client_id = settings.getKeycloak().getClientId();
        this.client_secret = settings.getKeycloak().getSecretId();
        this.token = token;
        this.grant_type = "client_credentials";
    }
}
