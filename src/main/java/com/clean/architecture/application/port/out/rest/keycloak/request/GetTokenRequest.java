package com.clean.architecture.application.port.out.rest.keycloak.request;

import com.clean.architecture.adapters.AppSettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetTokenRequest {
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String scope;

    public GetTokenRequest(AppSettings settings) {
        this.client_id = settings.getKeycloak().getClientId();
        this.client_secret = settings.getKeycloak().getSecretId();
        this.grant_type = "client_credentials";
        this.scope = "openid";
    }
}
