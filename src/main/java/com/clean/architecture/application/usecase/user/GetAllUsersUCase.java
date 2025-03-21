package com.clean.architecture.application.usecase.user;

import com.clean.architecture.domain.entity.User;

import java.util.List;

public interface GetAllUsersUCase {
    List<User> getAll();
}
