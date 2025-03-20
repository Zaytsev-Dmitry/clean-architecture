package com.clean.architecture.application.port.in;

import com.clean.architecture.application.port.in.usecaseimpl.user.GetAllUsersUCaseImpl;
import com.clean.architecture.application.port.out.repository.UserRepository;
import com.clean.architecture.application.usecase.user.GetAllUsersUCase;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;


@Service
public class UserUCase implements GetAllUsersUCase {

    @Delegate
    private final GetAllUsersUCase getAllUsersUCase;

    public UserUCase(final UserRepository userRepository) {
        this.getAllUsersUCase = new GetAllUsersUCaseImpl(userRepository);
    }
}
