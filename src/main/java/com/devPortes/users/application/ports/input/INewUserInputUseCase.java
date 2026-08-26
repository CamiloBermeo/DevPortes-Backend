package com.devPortes.users.application.ports.input;

import com.devPortes.users.application.commands.NewUserCommand;

//entrada desde la infrastructure a application
public interface INewUserInputUseCase {
    NewUserResult execute (NewUserCommand userCommand);
}
