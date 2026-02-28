package com.Project.Leaning.LearningRESTAPIs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String SubjectName;

    private String SubjectDescription;

    private Date Duedate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long student_id;

}
