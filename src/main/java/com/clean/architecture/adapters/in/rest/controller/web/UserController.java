package com.clean.architecture.adapters.in.rest.controller.web;

import com.clean.architecture.adapters.in.rest.presenter.user.UserPresenter;
import com.clean.architecture.application.port.in.delegate.UserUCaseDelegate;
import com.generated.swaggerCodegen.api.CleanArchitectureApi;
import com.generated.swaggerCodegen.model.ListUserBackendResponse;
import com.generated.swaggerCodegen.model.SingleUserBackendResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserController implements CleanArchitectureApi {
    private final UserPresenter presenter;
    private final UserUCaseDelegate delegate;

    @Override
    public ResponseEntity<ListUserBackendResponse> getAllUsers() {
        return ResponseEntity.ok(this.presenter.mapToListResponse(this.delegate.getAll()));
    }

    @Override
    public ResponseEntity<SingleUserBackendResponse> getUserByUid(final String uid) {
        return ResponseEntity.ok(this.presenter.mapToSingleResponse(this.delegate.getByUid(uid)));
    }
}
