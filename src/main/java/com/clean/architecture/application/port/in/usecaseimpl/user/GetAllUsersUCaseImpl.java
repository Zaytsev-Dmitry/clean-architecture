package com.clean.architecture.application.port.in.usecaseimpl.user;

import com.clean.architecture.application.port.out.repository.UserRepository;
import com.clean.architecture.application.usecase.user.GetAllUsersUCase;
import com.clean.architecture.domain.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllUsersUCaseImpl implements GetAllUsersUCase {
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
