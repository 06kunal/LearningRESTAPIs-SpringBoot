package com.Project.Leaning.LearningRESTAPIs.dto;


import com.Project.Leaning.LearningRESTAPIs.entity.Student;
import com.Project.Leaning.LearningRESTAPIs.entity.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String className;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Student> students;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Subject> subjects;
}
