package com.clean.architecture.adapters.in.rest.api.web;

import com.clean.architecture.adapters.in.rest.controller.web.UserController;
import com.clean.architecture.adapters.in.rest.validator.aspecj.ValidateEndpointParameters;
import com.generated.swaggerCodegen.api.CleanArchitectureApi;
import com.generated.swaggerCodegen.model.SingleUserBackendResponse;
import com.generated.swaggerCodegen.model.UserBackendResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Slf4j
public class DecoratedWebApi extends AbstractLoggableApiDecorator implements CleanArchitectureApi {
    private final UserController userController;

    @ValidateEndpointParameters(endpointName = "getUserByUid", baseSchemeName = "getUserByUid")
    @Override
    public ResponseEntity<SingleUserBackendResponse> getUserByUid(final String uid) {
        return processing("getUserByUid", userController::getUserByUid, uid);
    }

    @Override
    public ResponseEntity<UserBackendResponse> getAllUsers() {
        return processing("getAllUsers", userController::getAllUsers);
    }
}
