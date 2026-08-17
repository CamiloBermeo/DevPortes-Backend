package com.devPortes.users.application.services;

import com.devPortes.users.application.ports.output.IUserRepository;
import com.devPortes.users.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserByEmailService {
    private final IUserRepository findUserByEmail;

    public Optional<UserModel> execute (String email){
        return findUserByEmail.findByEmail(email);
    }

}
