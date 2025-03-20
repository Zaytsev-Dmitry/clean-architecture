package com.clean.architecture.adapters.rest.api;

import com.clean.architecture.adapters.rest.controller.UserController;
import com.generated.swaggerCodegen.api.ExampleApi;
import com.generated.swaggerCodegen.model.UserBackendResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class DecoratedWebApi extends AbstractLoggableApiDecorator implements ExampleApi {
    private final UserController userController;

    @Override
    public ResponseEntity<UserBackendResponse> testEndpoint() {
        return processing("testEndpoint", userController::testEndpoint);
    }
}
