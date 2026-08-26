package com.devPortes.users.infrastructure.input.controllers;

import com.devPortes.users.application.ports.input.ILoginInputUseCase;
import com.devPortes.users.application.ports.input.INewUserInputUseCase;
import com.devPortes.users.application.ports.input.LoginSuccessResult;
import com.devPortes.users.application.ports.input.NewUserResult;
import com.devPortes.users.infrastructure.input.dtos.LoginDataDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserRequestDto;
import com.devPortes.users.infrastructure.input.dtos.NewUserResponseDto;
import com.devPortes.users.infrastructure.input.dtos.TokenDataDto;
import com.devPortes.users.infrastructure.input.mapper.UserInMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final INewUserInputUseCase iNewUserInputUseCase;
    private final ILoginInputUseCase iLoginInputUseCase;

    @PostMapping("register")
    public ResponseEntity<NewUserResponseDto> register(@Valid @RequestBody NewUserRequestDto dto) {
        NewUserResult newUserResult = iNewUserInputUseCase.execute(UserInMapper.toNewUserCommand(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new NewUserResponseDto(newUserResult.userName(), newUserResult.token()));
    }

    @PostMapping("login")
    public ResponseEntity<TokenDataDto> login(@Valid @RequestBody LoginDataDto dto){
        LoginSuccessResult loginResult = iLoginInputUseCase.execute(UserInMapper.toLoginCommand(dto));
        return ResponseEntity.status(HttpStatus.OK)
                .body(new TokenDataDto(loginResult.token()));
    }
  /*
    @GetMapping("profile")
    public ResponseEntity<UserResponseDTO> myProfile(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok(UserAppMapper.toDtoProfile(customUserDetails.getUser()));
    }

   */
}