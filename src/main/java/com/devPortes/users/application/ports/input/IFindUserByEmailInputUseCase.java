package com.devPortes.users.application.ports.input;

import com.devPortes.users.domain.model.UserModel;

import java.util.Optional;

public interface IFindUserByEmailInputUseCase {
    Optional<UserModel> execute(String email);

}
