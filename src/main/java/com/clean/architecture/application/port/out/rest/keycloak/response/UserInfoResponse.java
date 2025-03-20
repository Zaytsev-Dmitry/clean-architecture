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
public class UserInfoResponse {

    @JsonProperty(value = "sub")
    private String sub;

    @JsonProperty(value = "email_verified")
    private boolean emailVerified;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "email")
    private String email;
}
