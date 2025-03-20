package com.clean.architecture.domain;

import com.clean.architecture.application.port.out.rest.keycloak.response.UserInfoResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class CleanArchitectureUserDetails extends CleanArchitectureAuthDetails {
    public static final String ROLE = "ROLE_USER";

    public CleanArchitectureUserDetails(UserInfoResponse userInfoResponse) {
        super(userInfoResponse);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ROLE));
    }
}
