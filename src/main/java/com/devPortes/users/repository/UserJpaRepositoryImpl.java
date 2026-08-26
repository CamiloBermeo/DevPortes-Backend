package com.devPortes.users.repository;

import com.devPortes.users.model.UserModel;
import com.devPortes.users.entities.UserEntity;
import com.devPortes.users.mapper.UserOutMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryImpl {
    private final IUserJpaRepository jpa;

    public Optional<UserModel> findByEmail(String email) {

        Optional<UserEntity> entity = jpa.findByEmail(email);

        return entity.map(UserOutMapper::toModel);
    }

    public UserModel save(UserModel user) {
        UserEntity entity = UserOutMapper.toEntity(user);
        return UserOutMapper.toModel(jpa.save(entity));
    }
}
