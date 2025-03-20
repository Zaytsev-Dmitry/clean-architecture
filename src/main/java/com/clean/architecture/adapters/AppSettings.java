package com.clean.architecture.adapters;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("clean-architecture")
@Data
public class AppSettings {
    private Keycloak keycloak;

    @Data
    public static class Keycloak {
        private String host;
        private String clientId;
        private String secretId;
        private String introspectUrl;
        private String userinfoUrl;
        private String tokenUrl;
    }
}