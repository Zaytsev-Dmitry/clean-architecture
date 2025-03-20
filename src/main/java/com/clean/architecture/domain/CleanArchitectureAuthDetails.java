package com.clean.architecture.domain;

import com.clean.architecture.application.port.out.rest.keycloak.response.UserInfoResponse;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class CleanArchitectureAuthDetails implements UserDetails {
    private final UserInfoResponse userInfoResponse;

    public CleanArchitectureAuthDetails(final UserInfoResponse userInfoResponse) {
        this.userInfoResponse = userInfoResponse;
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getUsername() {
        return this.userInfoResponse.getName();
    }

    public UserInfoResponse getAccount() {
        return this.userInfoResponse;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //TODO доделать
    @Override
    public boolean isEnabled() {
        return true;
    }

}
