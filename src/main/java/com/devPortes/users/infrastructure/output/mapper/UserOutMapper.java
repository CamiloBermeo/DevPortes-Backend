package com.devPortes.users.infrastructure.output.mapper;

import com.devPortes.users.domain.model.UserModel;
import com.devPortes.users.infrastructure.output.entities.UserEntity;

public class UserOutMapper {

    public static UserEntity toEntity(UserModel model){
        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setIdentityDocument(model.getIdentityDocument());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setEmail(model.getEmail());
        entity.setPasswordHash(model.getPasswordHash());
        entity.setClassification(model.getClassification());
        entity.setReserveAmount(model.getReservationAmount());
        entity.setRole(model.getRole());
        return entity;
    }

    public static UserModel toModel(UserEntity entity){
        return UserModel.reconstitute(
                entity.getId(),
                entity.getName(),
                entity.getIdentityDocument(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getClassification(),
                entity.getReserveAmount(),
                entity.getRole()
        );
    }

}
