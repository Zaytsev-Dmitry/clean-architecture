package com.clean.architecture.adapters.rest.presenter.user;

import com.clean.architecture.adapters.rest.presenter.base.BaseListPresenter;
import com.clean.architecture.domain.entity.User;
import com.generated.swaggerCodegen.model.UserBackendResponse;
import com.generated.swaggerCodegen.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserListPresenter extends BaseListPresenter<UserBackendResponse, User> {

    @Override
    protected UserBackendResponse newResponse(final List<User> req) {
        UserBackendResponse result = new UserBackendResponse();
        result.setPayload(
                req.stream().map(obj -> {
                    UserResponse resp = new UserResponse();
                    resp.setId(obj.getId());
                    resp.setType(obj.getType());
                    resp.setUid(obj.getUid());
                    resp.setIsActive(obj.getIsActive());
                    return resp;
                }).collect(Collectors.toList())
        );
        return result;
    }
}
