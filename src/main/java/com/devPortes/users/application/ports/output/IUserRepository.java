package com.devPortes.users.application.ports.output;

import com.devPortes.users.domain.model.UserModel;

import java.util.Optional;

public interface IUserRepository {

    Optional<UserModel> findByEmail(String email);

}
