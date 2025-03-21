package com.clean.architecture.application.usecase.user.impl;

import com.clean.architecture.application.port.out.repository.UserRepository;
import com.clean.architecture.application.usecase.user.GetUserByIdUCase;
import com.clean.architecture.domain.entity.User;
import com.clean.architecture.domain.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service(value = "GetUserByIdImpl")
@AllArgsConstructor
public class GetUserByIdUCaseImpl implements GetUserByIdUCase {
    private UserRepository repository;

    @Override
    public User getByUid(final String uid) {
        return this.repository.getByUid(uid).orElseThrow(() -> new NotFoundException(
                String.format("Пользователь с uid: %s не найден", uid)
        ));
    }
}
