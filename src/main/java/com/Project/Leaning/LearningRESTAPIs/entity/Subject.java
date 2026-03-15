package com.Project.Leaning.LearningRESTAPIs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String createdBy;

    private String subjectName;

    private String subjectDescription;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Boolean active = true;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonBackReference
    private ClassEntity classEntity;
}
