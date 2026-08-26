package com.devPortes.users.infrastructure.input.mapper;

import com.devPortes.users.application.commands.LoginCommand;
import com.devPortes.users.application.commands.NewUserCommand;
import com.devPortes.users.infrastructure.input.dtos.LoginDataDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;

public class UserInMapper {

    public static NewUserCommand toNewUserCommand(NewUserRequestDto dto){
        return new NewUserCommand(
                dto.name(),
                dto.identityDocument(),
                dto.phoneNumber(),
                dto.email(),
                dto.password()
        );
    }
    public static LoginCommand toLoginCommand (LoginDataDto dto){
        return new LoginCommand(
                dto.email(),
                dto.password()
        );
    }
}
