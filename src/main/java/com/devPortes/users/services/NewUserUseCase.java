package com.devPortes.users.services;

import com.devPortes.users.dto.NewUserRequestDto;
import com.devPortes.users.dto.NewUserResponseDto;
import com.devPortes.users.mapper.UserInMapper;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import com.devPortes.users.security.BCryptPasswordEncoderAdapter;
import com.devPortes.users.security.CustomUserDetails;
import com.devPortes.users.exceptions.ExistingUserDataBaseException;
import com.devPortes.users.model.Client;
import com.devPortes.users.security.TokenImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserUseCase implements INewUserUseCase{
    private final IFindUserByEmailUseCase iFindUserByEmail;
    private final BCryptPasswordEncoderAdapter bCryptPasswordEncoder;
    private final UserJpaRepositoryAdapter userRepository;
    private final TokenImpl tokenImpl;

    @Override
    public NewUserResponseDto execute(NewUserRequestDto dto) {

        //1. verifico que el usuario no este registrado previamente
        iFindUserByEmail.findClientByEmail(dto.email())
                .ifPresent(userModelSave -> {
                    throw new ExistingUserDataBaseException(userModelSave.getEmail());
                });

        String passwordHash = bCryptPasswordEncoder.encodePassword(dto.password());

        Client user = UserInMapper.toModel(dto, passwordHash);

        Client saveUser = userRepository.save(user);

        String token = tokenImpl.generateNewToken(new CustomUserDetails(saveUser));

        return UserInMapper.toNewUserDto(saveUser, token);
    }
}