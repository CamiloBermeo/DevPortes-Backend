package com.devPortes.users.application.ports.output;

import com.devPortes.users.domain.model.UserModel;

import java.util.Optional;

public interface IUserRepositoryOutputPort {

    Optional<UserModel> findByEmail(String email);
    UserModel save(UserModel user);

}
