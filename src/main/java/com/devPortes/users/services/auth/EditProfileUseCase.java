package com.devPortes.users.services.auth;

import com.devPortes.users.dto.auth.EditProfileRequestDto;
import com.devPortes.users.dto.auth.NewUserResponseDto;
import com.devPortes.users.exceptions.UserNotFoundException;
import com.devPortes.users.mapper.UserInMapper;
import com.devPortes.users.model.Client;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProfileUseCase implements IEditProfileUseCase {

    private final UserJpaRepositoryAdapter clientRepository;

    @Override
    public NewUserResponseDto execute(Long userId, EditProfileRequestDto dto) {
        Client existingClient = clientRepository.finById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));

        Client editClient = UserInMapper.toEditProfileModel(existingClient, dto);
        Client savedClient = clientRepository.saveEdit(userId, editClient);

        return UserInMapper.toDtoProfile(savedClient);
    }
}
