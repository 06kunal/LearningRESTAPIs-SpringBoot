package com.Project.Leaning.LearningRESTAPIs.service;

import com.Project.Leaning.LearningRESTAPIs.entity.Student;
import com.Project.Leaning.LearningRESTAPIs.enums.Role;
import com.Project.Leaning.LearningRESTAPIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private StudentRepository studentRepository;

    public String promoteToAdmin(String email){

        Student admin = studentRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found. Register first"));

        if (admin.getRole().equals(Role.ADMIN)){
            throw new RuntimeException(("User is already admin"));
        }

        admin.setRole(Role.ADMIN);
        studentRepository.save(admin);

        log.info("Admin created");
        return ("Admin created");
    }
}
