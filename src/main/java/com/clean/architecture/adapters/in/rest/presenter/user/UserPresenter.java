package com.clean.architecture.adapters.in.rest.presenter.user;

import com.clean.architecture.adapters.in.rest.presenter.base.BasePresenter;
import com.clean.architecture.domain.entity.User;
import com.generated.swaggerCodegen.model.ListUserBackendResponse;
import com.generated.swaggerCodegen.model.SingleUserBackendResponse;
import com.generated.swaggerCodegen.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPresenter extends BasePresenter<User, UserResponse, SingleUserBackendResponse, ListUserBackendResponse> {

    @Override
    protected UserResponse map(final User entity) {
        UserResponse resp = new UserResponse();
        resp.setIsActive(entity.getIsActive());
        resp.setId(entity.getId());
        resp.setType(entity.getType());
        resp.setUid(entity.getUid());
        return resp;
    }

    @Override
    protected ListUserBackendResponse createListResponse(final List<UserResponse> collection) {
        ListUserBackendResponse resp = new ListUserBackendResponse();
        resp.setPayload(collection);
        return resp;
    }

    @Override
    protected SingleUserBackendResponse createSingleResponse(final UserResponse single) {
        SingleUserBackendResponse resp = new SingleUserBackendResponse();
        resp.setPayload(single);
        return resp;
    }
}
