package com.devPortes.users.application.services;

import com.devPortes.users.application.ports.output.ITokenOutputPort;
import com.devPortes.users.infrastructure.input.security.CustomUserDetails;
import com.devPortes.users.application.commands.NewUserCommand;
import com.devPortes.users.application.ports.input.INewUserInputUseCase;
import com.devPortes.users.application.ports.input.NewUserResult;
import com.devPortes.users.application.ports.output.IPasswordEncoderPort;
import com.devPortes.users.application.ports.output.IUserRepositoryOutputPort;
import com.devPortes.users.domain.exceptions.ExistingUserDataBaseException;
import com.devPortes.users.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserServiceUseCase implements INewUserInputUseCase {
    private final FindUserByEmailInputUseCaseService findUserByEmail;
    private final IPasswordEncoderPort iPasswordEncoderPort;
    private final IUserRepositoryOutputPort userRepository;
    private final ITokenOutputPort iTokenOutputPort;

    @Override
    public NewUserResult execute(NewUserCommand command) {

        //1. verifico que el usuario no este registrado previamente
        findUserByEmail.execute(command.email())
                .ifPresent(userModelSave -> {
                    throw new ExistingUserDataBaseException(userModelSave.getEmail());
                });

        String passwordHash = iPasswordEncoderPort.encodePassword(command.password());

        UserModel user = UserModel.create(
                command.name(),
                command.identityDocument(),
                command.phoneNumber(),
                command.email(),
                passwordHash,
                null
        );

        UserModel saveUser = userRepository.save(user);
        String token = iTokenOutputPort.generateNewToken(new CustomUserDetails(saveUser));

        return new NewUserResult(saveUser.getName(), token);
    }
}