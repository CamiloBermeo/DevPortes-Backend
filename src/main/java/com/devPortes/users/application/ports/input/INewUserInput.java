package com.devPortes.users.application.ports.input;

import com.devPortes.users.application.commands.NewUserCommand;
import com.devPortes.users.domain.model.UserModel;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
//entrada desde la infrastructure a application
public interface INewUserInput {
    NewUserResult execute (NewUserCommand userCommand);
}
