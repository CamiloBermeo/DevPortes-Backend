package com.devPortes.users.mapper;

import com.devPortes.users.model.UserModel;
import com.devPortes.users.entities.ClientEntity;

public class UserOutMapper {

    public static ClientEntity toEntity(UserModel model){
        ClientEntity entity = new ClientEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setIdentityDocument(model.getIdentityDocument());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setEmail(model.getEmail());
        entity.setPasswordHash(model.getPasswordHash());
        entity.setClassification(model.getClassification());
        entity.setReservationAmount(model.getReservationAmount());
        entity.setRole(model.getRole());
        return entity;
    }

    public static UserModel toModel(ClientEntity entity){
        return UserModel.reconstitute(
                entity.getId(),
                entity.getName(),
                entity.getIdentityDocument(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getClassification(),
                entity.getReservationAmount(),
                entity.getRole(),
                entity.isState()
        );
    }

}
