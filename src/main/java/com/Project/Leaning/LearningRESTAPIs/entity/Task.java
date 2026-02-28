package com.Project.Leaning.LearningRESTAPIs.entity;

import com.Project.Leaning.LearningRESTAPIs.enums.TaskPriority;
import com.Project.Leaning.LearningRESTAPIs.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private Date due_date;

    @Enumerated(EnumType.STRING)
    private TaskStatus task_status;

    @Enumerated(EnumType.STRING)
    private TaskPriority task_priority;

    private Long student_id;

    private Long subject_id;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}
