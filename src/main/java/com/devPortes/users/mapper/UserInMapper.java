package com.devPortes.users.mapper;

import com.devPortes.users.dto.NewUserRequestDto;
import com.devPortes.users.dto.NewUserResponseDto;
import com.devPortes.users.model.UserModel;

public class UserInMapper {

    public static UserModel toModel(NewUserRequestDto dto, String passwordHash){
        return UserModel.create(
                dto.name(),
                dto.identityDocument(),
                dto.phoneNumber(),
                dto.email(),
                passwordHash,
                null
        );

    }
    public static NewUserResponseDto toNewUserDto (UserModel user, String token){
        return new NewUserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                token
        );
    }

    public static NewUserResponseDto toDtoProfile(UserModel user){
        return new NewUserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                ""
        );
    }
}
