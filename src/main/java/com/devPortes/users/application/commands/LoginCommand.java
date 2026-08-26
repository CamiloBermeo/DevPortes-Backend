package com.devPortes.users.application.commands;

public record LoginCommand(
        String email,
        String password
) {
}
