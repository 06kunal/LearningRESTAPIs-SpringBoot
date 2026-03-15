package com.Project.Leaning.LearningRESTAPIs.dto;

import com.Project.Leaning.LearningRESTAPIs.enums.TaskPriority;
import com.Project.Leaning.LearningRESTAPIs.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TaskDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private TaskStatus taskStatus;

    private TaskPriority taskPriority;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime created_at;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updated_at;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean active;

    private LocalDateTime completionDate;
}
