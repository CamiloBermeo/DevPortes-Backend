package com.devPortes.users.infrastructure.input.mapper;

import com.devPortes.users.application.commands.NewUserCommand;
import com.devPortes.users.domain.model.UserModel;
import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;

public class UserInMapper {

    public static NewUserCommand toCommand(NewUserRequestDto dto){
        return new NewUserCommand(
                dto.name(),
                dto.identityDocument(),
                dto.phoneNumber(),
                dto.email(),
                dto.password(),
                dto.role()
        );

    }

}
