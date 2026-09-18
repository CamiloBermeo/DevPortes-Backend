package com.devPortes.users.services;

import com.devPortes.users.dto.ListUsersResponseDto;

import java.util.List;

public interface IListUsersUseCase {
    List<ListUsersResponseDto> execute();
}
