package com.devPortes.users.mapper;

import com.devPortes.users.dto.NewUserRequestDto;
import com.devPortes.users.dto.NewUserResponseDto;
import com.devPortes.users.model.Client;
import com.devPortes.users.model.IAuthenticated;

public class UserInMapper {

    public static Client toModel(NewUserRequestDto dto, String passwordHash){
        return Client.create(
                dto.name(),
                dto.identityDocument(),
                dto.phoneNumber(),
                dto.email(),
                passwordHash,
                null
        );

    }
    public static NewUserResponseDto toNewUserDto (Client user, String token){
        return new NewUserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                token
        );
    }

    public static NewUserResponseDto toDtoProfile(IAuthenticated user){
        return new NewUserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                ""
        );
    }
}
