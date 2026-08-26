package com.devPortes.users.controllers;

import com.devPortes.users.dto.*;
import com.devPortes.users.mapper.UserInMapper;
import com.devPortes.users.security.CustomUserDetails;
import com.devPortes.users.services.LoginService;
import com.devPortes.users.services.NewUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final NewUserService newUserService;
    private final LoginService loginService;

    @PostMapping("register")
    public ResponseEntity<NewUserResponseDto> register(@Valid @RequestBody NewUserRequestDto dto) {
        NewUserResponseDto newUserResult = newUserService.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newUserResult);
    }

    @PostMapping("login")
    public ResponseEntity<TokenDataDto> login(@Valid @RequestBody LoginDataRequestDto dto){
        TokenDataDto tokenResponse = loginService.execute(dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(tokenResponse);
    }

    @GetMapping("profile")
    public ResponseEntity<NewUserResponseDto> myProfile(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return ResponseEntity.ok(UserInMapper.toDtoProfile(customUserDetails.getUser()));
    }

}