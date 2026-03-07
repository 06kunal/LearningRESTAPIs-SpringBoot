package com.Project.Leaning.LearningRESTAPIs.config;

import com.Project.Leaning.LearningRESTAPIs.entity.Student;
import com.Project.Leaning.LearningRESTAPIs.enums.Role;
import com.Project.Leaning.LearningRESTAPIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class AdminInitializer implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) {

        if (studentRepository.findByEmail("admin@gmail.com").isEmpty()) {
            Student admin = new Student();

            admin.setEmail("admin@gmail.com");
            admin.setPassword("admin");
            admin.setRole(Role.ADMIN);
            studentRepository.save(admin);

            log.info("Successfully added admin");
        } else {
            log.info("Admin already exists");
        }
    }
}
