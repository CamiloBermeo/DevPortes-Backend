package com.devPortes.users.infrastructure.input.controllers;

import com.devPortes.users.application.ports.input.IUserInput;
import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthController {
    private final IUserInput iUserInput;

    @PutMapping("register")
    public ResponseEntity<NewUserResponseDto> register(@Valid @RequestBody NewUserRequestDto dto){
        NewUserResponseDto newUserResponse = iUserInput.newUser(dto);
    return ResponseEntity.ok(newUserResponse);
    }

}
