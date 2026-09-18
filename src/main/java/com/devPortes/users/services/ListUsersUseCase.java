package com.devPortes.users.services;

import com.devPortes.users.dto.ListUsersResponseDto;
import com.devPortes.users.mapper.UserOutMapper;
import com.devPortes.users.repository.UserJpaRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListUsersUseCase implements IListUsersUseCase {
    private final UserJpaRepositoryAdapter userRepository;

    @Override
    public List<ListUsersResponseDto> execute() {
        return userRepository.findAllClients().stream()
                .map(UserOutMapper::toUserDto)
                .toList();
    }
}
