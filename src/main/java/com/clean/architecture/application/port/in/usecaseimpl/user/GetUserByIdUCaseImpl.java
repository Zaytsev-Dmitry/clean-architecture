package com.clean.architecture.application.port.in.usecaseimpl.user;

import com.clean.architecture.application.port.out.repository.UserRepository;
import com.clean.architecture.application.usecase.user.GetAllUsersUCase;
import com.clean.architecture.application.usecase.user.GetUserByIdUCase;
import com.clean.architecture.domain.entity.User;
import com.clean.architecture.domain.exception.NotFoundException;
import com.clean.architecture.domain.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
