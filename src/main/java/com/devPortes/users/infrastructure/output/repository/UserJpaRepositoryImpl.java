package com.devPortes.users.infrastructure.output.repository;

import com.devPortes.users.application.ports.output.IUserRepository;
import com.devPortes.users.domain.model.UserModel;
import com.devPortes.users.infrastructure.output.entities.UserEntity;
import com.devPortes.users.infrastructure.output.mapper.UserOutMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryImpl implements IUserRepository {
    private final IUserJpaRepository jpa;

    @Override
    public Optional<UserModel> findByEmail(String email) {

        Optional<UserEntity> entity = jpa.findByEmail(email);

        return entity.map(UserOutMapper::toModel);
    }
}
