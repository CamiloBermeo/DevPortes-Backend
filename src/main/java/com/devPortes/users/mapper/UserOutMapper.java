package com.devPortes.users.mapper;

import com.devPortes.users.entities.AdminEntity;
import com.devPortes.users.model.Admin;
import com.devPortes.users.model.Client;
import com.devPortes.users.entities.ClientEntity;
import com.devPortes.users.model.IAuthenticated;
import com.devPortes.users.model.RoleEnum;

public class UserOutMapper {

    public static ClientEntity toClientEntity(Client model){
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

    public static Client toClientCompleteModel(ClientEntity entity){
        return Client.reconstitute(
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

    public static Admin toAdminCompleteModel(AdminEntity entity){
        return Admin.reconstitute(
                entity.getId(),
                entity.getName(),
                entity.getIdentityDocument(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getRole(),
                entity.isState()
        );
    }

}
