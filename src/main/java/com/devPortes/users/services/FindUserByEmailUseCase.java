package com.devPortes.users.services;

import com.devPortes.users.model.UserModel;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindUserByEmailUseCase implements IFindUserByEmailUseCase{
    private final UserJpaRepositoryAdapter userRepository;

    @Override
    public Optional<UserModel> execute (String email){
        return userRepository.findByEmail(email);
    }



}
