package com.devPortes.users.application.services;

import com.devPortes.users.application.commands.LoginCommand;
import com.devPortes.users.application.ports.input.ILoginInputUseCase;
import com.devPortes.users.application.ports.input.LoginSuccessResult;
import com.devPortes.users.application.ports.output.IPasswordEncoderPort;
import com.devPortes.users.application.ports.output.ITokenOutputPort;
import com.devPortes.users.application.ports.output.IUserRepositoryOutputPort;
import com.devPortes.users.domain.exceptions.InvalidCredentialException;
import com.devPortes.users.domain.model.UserModel;
import com.devPortes.users.infrastructure.input.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginUseCase implements ILoginInputUseCase {
    private final IPasswordEncoderPort iPasswordEncoderPort;
    private final IUserRepositoryOutputPort iUserRepositoryOutputPort;
    private final ITokenOutputPort iTokenOutputPort;

    @Override
    public LoginSuccessResult execute(LoginCommand command) {

        UserModel saveUser = iUserRepositoryOutputPort.findByEmail(command.email())
                .orElseThrow(InvalidCredentialException::new);

        boolean isMatch = iPasswordEncoderPort.matchesPasswords(
                command.password(), saveUser.getPasswordHash());

        if (!isMatch){
            throw new InvalidCredentialException();
        }
        String token = iTokenOutputPort.generateNewToken(new CustomUserDetails(saveUser));

        return new LoginSuccessResult(token);
    }
}
