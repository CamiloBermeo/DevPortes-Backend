package com.devPortes.users.controllers;

import com.devPortes.users.dto.ListUsersResponseDto;
import com.devPortes.users.services.IListUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {
    private final IListUsersUseCase iListUsersUseCase;

    @GetMapping("clients")
    public ResponseEntity<List<ListUsersResponseDto>> getUsers() {
        return ResponseEntity.ok(iListUsersUseCase.execute());
    }
}
