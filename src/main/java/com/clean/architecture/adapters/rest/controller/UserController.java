package com.clean.architecture.adapters.rest.controller;

import com.clean.architecture.adapters.rest.presenter.user.UserListPresenter;
import com.clean.architecture.adapters.rest.presenter.user.UserSinglePresenter;
import com.clean.architecture.application.port.in.delegate.UserUCaseDelegate;
import com.generated.swaggerCodegen.api.CleanArchitectureApi;
import com.generated.swaggerCodegen.model.SingleUserBackendResponse;
import com.generated.swaggerCodegen.model.UserBackendResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserController implements CleanArchitectureApi {
    private final UserListPresenter listPresenter;
    private final UserSinglePresenter singlePresenter;
    private final UserUCaseDelegate delegate;

    @Override
    public ResponseEntity<UserBackendResponse> getAllUsers() {
        return ResponseEntity.ok(this.listPresenter.present(this.delegate.getAll()));
    }

    @Override
    public ResponseEntity<SingleUserBackendResponse> getUserByUid(final String uid) {
        return ResponseEntity.ok(this.singlePresenter.present(this.delegate.getByUid(uid)));
    }
}
