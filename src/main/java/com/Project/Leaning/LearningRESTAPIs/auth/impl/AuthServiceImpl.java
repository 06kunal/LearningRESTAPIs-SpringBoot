package com.Project.Leaning.LearningRESTAPIs.auth.impl;

import com.Project.Leaning.LearningRESTAPIs.auth.AuthService;
import com.Project.Leaning.LearningRESTAPIs.auth.JwtService;
import com.Project.Leaning.LearningRESTAPIs.dto.AuthResponse;
import com.Project.Leaning.LearningRESTAPIs.dto.LoginRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.RegisterRequestDto;
import com.Project.Leaning.LearningRESTAPIs.dto.StudentDto;
import com.Project.Leaning.LearningRESTAPIs.entity.Student;
import com.Project.Leaning.LearningRESTAPIs.enums.Role;
import com.Project.Leaning.LearningRESTAPIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequestDto registerRequestDto) {

        log.info("Registration started");
        Student newStudent = modelMapper.map(registerRequestDto, Student.class);

        newStudent.setRole(Role.STUDENT);
        newStudent.setCreatedAt(LocalDateTime.now());
        newStudent.setActive(true);


        Student student = studentRepository.save(newStudent);
        modelMapper.map(student, StudentDto.class);

        String token = jwtService.generateToken(newStudent.getEmail());

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequestDto request) {

        Student student = studentRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        if (!Objects.equals(request.getPassword(), student.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(student.getEmail());

        return new AuthResponse(token);

    }
}
