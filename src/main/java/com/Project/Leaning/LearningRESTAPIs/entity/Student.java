package com.Project.Leaning.LearningRESTAPIs.entity;


import com.Project.Leaning.LearningRESTAPIs.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String password2;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phone;

    private String address;

    private Boolean active;

    private LocalDateTime createdAt;
}
