package com.Project.Leaning.LearningRESTAPIs.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    @OneToMany(mappedBy = "classEntity")
    @JsonManagedReference
    private List<Student> students;

    @OneToMany(mappedBy = "classEntity")
    @JsonManagedReference
    private List<Subject> subjects;
}
