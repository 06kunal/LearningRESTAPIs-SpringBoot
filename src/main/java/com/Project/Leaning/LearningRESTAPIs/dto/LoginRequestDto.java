package com.Project.Leaning.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDto {

    @Email
    @NotBlank(message = "email is Required")
    private String email;

    @NotBlank
    private String password;

}
