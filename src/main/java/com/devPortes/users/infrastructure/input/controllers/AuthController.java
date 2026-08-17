package com.devPortes.users.infrastructure.input.controllers;

import com.devPortes.users.application.ports.input.INewUserInput;
import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
import com.devPortes.users.infrastructure.input.mapper.UserInMapper;
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
    private final INewUserInput iNewUserInput;

    @PutMapping("register")
    public ResponseEntity<NewUserResponseDto> register(@Valid @RequestBody NewUserRequestDto dto){
        NewUserResponseDto newUserResponse = iNewUserInput.execute(UserInMapper.toCommand(dto));
    return ResponseEntity.ok(newUserResponse);
    }

}
