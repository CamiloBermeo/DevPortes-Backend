package com.devPortes.users.application.services;

import com.devPortes.users.application.commands.NewUserCommand;
import com.devPortes.users.application.ports.input.INewUserInput;
import com.devPortes.users.domain.exceptions.ExistingUserDataBaseException;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
import com.devPortes.users.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserService implements INewUserInput {
    private final FindUserByEmailService findUserByEmail;
    private final PasswordEncoder passwordEncoder;

    @Override
    public NewUserResponseDto execute(NewUserCommand command) {

        //1. verifico que el usuario no este registrado previamente
        findUserByEmail.execute(command.email())
                .ifPresent(userModelSave -> {
                    throw new ExistingUserDataBaseException(userModelSave.getEmail());
                });

        String passwordHash = passwordEncoder.encode(command.password());

        return null;
    }
}