package com.clean.architecture.application.usecase.user;

import com.clean.architecture.domain.User;

import java.util.List;

public interface GetAllUsersUCase {
    List<User> getAll();
}
