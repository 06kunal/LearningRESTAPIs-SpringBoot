package com.Project.Leaning.LearningRESTAPIs.entity;

import com.Project.Leaning.LearningRESTAPIs.enums.TaskPriority;
import com.Project.Leaning.LearningRESTAPIs.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;

    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    private Boolean active = true;

    private LocalDateTime completionDate = null;

}
