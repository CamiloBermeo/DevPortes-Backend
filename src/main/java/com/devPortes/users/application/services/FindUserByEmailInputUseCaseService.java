package com.devPortes.users.application.services;

import com.devPortes.users.application.ports.input.IFindUserByEmailInputUseCase;
import com.devPortes.users.application.ports.output.IUserRepositoryOutputPort;
import com.devPortes.users.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserByEmailInputUseCaseService implements IFindUserByEmailInputUseCase {
    private final IUserRepositoryOutputPort findUserByEmail;

    @Override
    public Optional<UserModel> execute (String email){
        return findUserByEmail.findByEmail(email);
    }



}
