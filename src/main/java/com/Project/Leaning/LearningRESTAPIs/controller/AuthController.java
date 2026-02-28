package com.Project.Leaning.LearningRESTAPIs.controller;

import com.Project.Leaning.LearningRESTAPIs.auth.AuthService;
import com.Project.Leaning.LearningRESTAPIs.dto.AuthResponse;
import com.Project.Leaning.LearningRESTAPIs.dto.LoginRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody @Valid RegisterRequestDto request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequestDto request){
        return authService.login(request);
    }
}
