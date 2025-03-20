package com.clean.architecture.application.port.out.rest.keycloak;


import com.clean.architecture.application.port.out.rest.keycloak.request.GetTokenRequest;
import com.clean.architecture.application.port.out.rest.keycloak.request.IntrospectTokenRequest;
import com.clean.architecture.application.port.out.rest.keycloak.response.GetTokenResponse;
import com.clean.architecture.application.port.out.rest.keycloak.response.IntrospectTokenResponse;
import com.clean.architecture.application.port.out.rest.keycloak.response.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "keycloak", url = "${clean-architecture.keycloak.host}")
public interface KeycloakClient {
    @PostMapping(value = "${clean-architecture.keycloak.tokenUrl}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    GetTokenResponse getToken(@RequestBody final GetTokenRequest request);

    @PostMapping(value = "${clean-architecture.keycloak.introspectUrl}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    IntrospectTokenResponse introspect(@RequestBody final IntrospectTokenRequest request);

    @GetMapping(value = "${clean-architecture.keycloak.userinfoUrl}")
    UserInfoResponse getUserInfo(@RequestHeader("Authorization") final String bearerToken);
}
