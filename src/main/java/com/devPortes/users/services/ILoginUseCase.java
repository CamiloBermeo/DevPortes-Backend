package com.devPortes.users.services;

import com.devPortes.users.dto.LoginDataRequestDto;
import com.devPortes.users.dto.TokenDataDto;

public interface ILoginUseCase {
    TokenDataDto execute(LoginDataRequestDto dto);
}
