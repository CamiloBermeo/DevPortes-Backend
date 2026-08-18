package com.devPortes.users.application.ports.input;

public record NewUserResult(
        String userName,
        String token
) {
}
