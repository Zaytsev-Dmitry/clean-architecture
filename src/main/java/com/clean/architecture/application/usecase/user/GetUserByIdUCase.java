package com.clean.architecture.application.usecase.user;

import com.clean.architecture.domain.entity.User;

public interface GetUserByIdUCase {
    User getByUid(final String uid);
}
