package com.devPortes.users.services;

import com.devPortes.users.model.UserModel;

import java.util.Optional;

public interface IFindUserByEmailUseCase {
    Optional<UserModel> execute (String email);
}
