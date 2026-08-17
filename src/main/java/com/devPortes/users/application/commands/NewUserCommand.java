package com.devPortes.users.application.commands;

import com.devPortes.users.domain.model.RoleEnum;

public record NewUserCommand(
        String name,
        String identityDocument,
        String phoneNumber,
        String email,
        String password
) {
}
