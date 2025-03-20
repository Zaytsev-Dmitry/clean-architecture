package com.clean.architecture.application.port.out.rest.keycloak.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetTokenResponse {
    @JsonProperty(value = "access_token")
    private String accessToken;

    @JsonProperty(value = "expires_in")
    private int expiresIn;

    @JsonProperty(value = "refresh_expires_in")
    private int refreshExpiresIn;

    @JsonProperty(value = "token_type")
    private String tokenType;

    @JsonProperty(value = "not-before-policy")
    private int notBeforePolicy;

    @JsonProperty(value = "scope")
    private String scope;
}
