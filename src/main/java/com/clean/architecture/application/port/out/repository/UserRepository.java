package com.clean.architecture.application.port.out.repository;

import com.clean.architecture.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUid(final String uid);
}
