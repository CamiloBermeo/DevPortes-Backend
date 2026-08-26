package com.devPortes.users.application.ports.input;

import com.devPortes.users.application.commands.LoginCommand;

public interface ILoginInputUseCase {
    LoginSuccessResult execute (LoginCommand command);
}
