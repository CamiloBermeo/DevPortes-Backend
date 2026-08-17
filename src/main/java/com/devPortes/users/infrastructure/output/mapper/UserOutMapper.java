package com.devPortes.users.infrastructure.output.mapper;

import com.devPortes.users.domain.model.RoleEnum;
import com.devPortes.users.domain.model.UserModel;
import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;
import com.devPortes.users.infrastructure.output.entities.UserEntity;

public class UserOutMapper {

    public static UserModel toModel(UserEntity entity){
        UserModel userModel = new UserModel();
        userModel.setId(entity.getId());
        userModel.setName(entity.getName());
        userModel.setIdentityDocument(entity.getIdentityDocument());
        userModel.setPhoneNumber(entity.getPhoneNumber());
        userModel.setEmail(entity.getEmail());
        userModel.setPasswordHash(entity.getPasswordHash());
        userModel.setRole(RoleEnum.valueOf(entity.getRole()));
        return userModel;
    }

}
