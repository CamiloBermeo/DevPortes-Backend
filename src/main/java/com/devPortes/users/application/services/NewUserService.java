package com.devPortes.users.application.services;

import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
import com.devPortes.users.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserService {

    public NewUserResponseDto execute (NewUserRequestDto dto){

        UserModel userModel = UserMapper

        return newUserResponse;
    }
}