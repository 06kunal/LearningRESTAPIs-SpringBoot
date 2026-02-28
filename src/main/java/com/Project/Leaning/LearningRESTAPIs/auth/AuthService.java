package com.Project.Leaning.LearningRESTAPIs.auth;

import com.Project.Leaning.LearningRESTAPIs.dto.AuthResponse;
import com.Project.Leaning.LearningRESTAPIs.dto.LoginRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;

public interface AuthService {

    AuthResponse register(RegisterRequestDto request);

    AuthResponse login(LoginRequestDto request);
}
