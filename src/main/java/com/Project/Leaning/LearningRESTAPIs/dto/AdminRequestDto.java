package com.Project.Leaning.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class AdminRequestDto {
    @Email
    @NotBlank(message = "email is Required")
    private String email;

}
