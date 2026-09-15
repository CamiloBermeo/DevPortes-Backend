package com.devPortes.users.services;

import com.devPortes.users.dto.NewUserRequestDto;
import com.devPortes.users.dto.NewUserResponseDto;

public interface INewUserUseCase{
    NewUserResponseDto execute(NewUserRequestDto dto);
}
