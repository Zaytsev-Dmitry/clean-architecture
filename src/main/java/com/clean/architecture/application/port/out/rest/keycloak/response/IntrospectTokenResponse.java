package com.clean.architecture.application.port.out.rest.keycloak.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntrospectTokenResponse {
    @JsonProperty(value = "exp")
    private long exp;

    @JsonProperty(value = "iss")
    private String iss;

    @JsonProperty(value = "email_verified")
    private boolean emailVerified;

    @JsonProperty(value = "client_id")
    private String clientId;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "active")
    private boolean active;
}
