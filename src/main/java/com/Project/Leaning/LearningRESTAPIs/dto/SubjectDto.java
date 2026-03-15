package com.Project.Leaning.LearningRESTAPIs.dto;

import com.Project.Leaning.LearningRESTAPIs.entity.ClassEntity;
import com.Project.Leaning.LearningRESTAPIs.entity.Task;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdBy;

    private String subjectName;

    private String subjectDescription;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean active;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<TaskDto> tasks;

    private Long classId;

    private String className;

}
