package com.clean.architecture.application.port.in.delegate;

import com.clean.architecture.application.usecase.user.GetAllUsersUCase;
import com.clean.architecture.application.usecase.user.GetUserByIdUCase;
import com.clean.architecture.domain.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserUCaseDelegate implements GetUserByIdUCase, GetAllUsersUCase {

    private final GetUserByIdUCase getUserByIdUCase;
    private final GetAllUsersUCase getAllUsersUCase;

    public UserUCaseDelegate(
            @Qualifier("GetUserByIdImpl") GetUserByIdUCase getUserByIdUCase,
            @Qualifier("GetAllUsersImpl") GetAllUsersUCase getAllUsersUCase
    ) {
        this.getUserByIdUCase = getUserByIdUCase;
        this.getAllUsersUCase = getAllUsersUCase;
    }

    @Override
    public List<User> getAll() {
        return this.getAllUsersUCase.getAll();
    }

    @Override
    public User getByUid(String uid) {
        return this.getUserByIdUCase.getByUid(uid);
    }
}
