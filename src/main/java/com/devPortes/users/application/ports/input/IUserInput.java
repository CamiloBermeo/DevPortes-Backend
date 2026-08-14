package com.devPortes.users.application.ports.input;

import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
//entrada desde la infrastructure a application
public interface IUserInput {
    NewUserResponseDto newUser (NewUserRequestDto dto);
}
