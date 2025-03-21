package com.clean.architecture.application.usecase.user.impl;

import com.clean.architecture.application.port.out.repository.UserRepository;
import com.clean.architecture.application.usecase.user.GetAllUsersUCase;
import com.clean.architecture.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "GetAllUsersImpl")
@AllArgsConstructor
public class GetAllUsersUCaseImpl implements GetAllUsersUCase {
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }
}
