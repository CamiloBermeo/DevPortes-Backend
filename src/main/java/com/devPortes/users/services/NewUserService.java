package com.devPortes.users.services;

import com.devPortes.users.dto.NewUserRequestDto;
import com.devPortes.users.dto.NewUserResponseDto;
import com.devPortes.users.mapper.UserInMapper;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import com.devPortes.users.security.BCryptPasswordEncoderAdapter;
import com.devPortes.users.security.CustomUserDetails;
import com.devPortes.users.exceptions.ExistingUserDataBaseException;
import com.devPortes.users.model.UserModel;
import com.devPortes.users.security.TokenImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserService{
    private final FindUserByEmailService findUserByEmail;
    private final BCryptPasswordEncoderAdapter bCryptPasswordEncoder;
    private final UserJpaRepositoryAdapter userRepository;
    private final TokenImpl tokenImpl;


    public NewUserResponseDto execute(NewUserRequestDto dto) {

        //1. verifico que el usuario no este registrado previamente
        findUserByEmail.execute(dto.email())
                .ifPresent(userModelSave -> {
                    throw new ExistingUserDataBaseException(userModelSave.getEmail());
                });

        String passwordHash = bCryptPasswordEncoder.encodePassword(dto.password());

        UserModel user = UserInMapper.toModel(dto, passwordHash);

        UserModel saveUser = userRepository.save(user);

        String token = tokenImpl.generateNewToken(new CustomUserDetails(saveUser));

        return UserInMapper.toNewUserDto(saveUser, token);
    }
}