package com.clean.architecture.adapters.rest.controller;

import com.clean.architecture.adapters.rest.presenter.UserPresenter;
import com.clean.architecture.application.port.in.UserUCase;
import com.generated.swaggerCodegen.api.ExampleApi;
import com.generated.swaggerCodegen.model.UserBackendResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserController implements ExampleApi {
    private final UserPresenter presenter;
    private final UserUCase uCase;

    @Override
    public ResponseEntity<UserBackendResponse> testEndpoint() {
        return ResponseEntity.ok(this.presenter.present(this.uCase.getAll()));
    }
}
