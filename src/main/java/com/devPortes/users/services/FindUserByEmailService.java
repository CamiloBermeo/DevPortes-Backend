package com.devPortes.users.services;

import com.devPortes.users.model.UserModel;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserByEmailService {
    private final UserJpaRepositoryAdapter userRepository;

    public Optional<UserModel> execute (String email){
        return userRepository.findByEmail(email);
    }



}
