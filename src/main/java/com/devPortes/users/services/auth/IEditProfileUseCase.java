package com.devPortes.users.services.auth;

import com.devPortes.users.dto.auth.EditProfileRequestDto;
import com.devPortes.users.dto.auth.NewUserResponseDto;

public interface IEditProfileUseCase {
    NewUserResponseDto execute(Long userId, EditProfileRequestDto dto);
}
