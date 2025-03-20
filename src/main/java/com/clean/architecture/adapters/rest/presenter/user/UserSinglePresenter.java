package com.clean.architecture.adapters.rest.presenter.user;

import com.clean.architecture.adapters.rest.presenter.base.BaseSinglePresenter;
import com.clean.architecture.domain.entity.User;
import com.generated.swaggerCodegen.model.SingleUserBackendResponse;
import com.generated.swaggerCodegen.model.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserSinglePresenter extends BaseSinglePresenter<SingleUserBackendResponse, User> {

    @Override
    protected SingleUserBackendResponse newResponse(final User obj) {
        UserResponse resp = new UserResponse();
        resp.setId(obj.getId());
        resp.setType(obj.getType());
        resp.setUid(obj.getUid());
        resp.setIsActive(obj.getIsActive());

        SingleUserBackendResponse result = new SingleUserBackendResponse();
        result.setPayload(resp);
        return result;
    }

}
