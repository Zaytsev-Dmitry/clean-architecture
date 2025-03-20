package com.clean.architecture.application.port.in;

import com.clean.architecture.application.usecase.user.GetAllUsersUCase;
import com.clean.architecture.application.usecase.user.GetUserByIdUCase;
import com.clean.architecture.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class UserUCaseDelegate implements GetUserByIdUCase, GetAllUsersUCase {
    @Qualifier("GetUserByIdImpl")
    private final GetUserByIdUCase getUserByIdUCase;

    @Qualifier("GetAllUsersImpl")
    private final GetAllUsersUCase getAllUsersUCase;

    @Override
    public List<User> getAll() {
        return this.getAllUsersUCase.getAll();
    }

    @Override
    public User getByUid(String uid) {
        return this.getUserByIdUCase.getByUid(uid);
    }
}
