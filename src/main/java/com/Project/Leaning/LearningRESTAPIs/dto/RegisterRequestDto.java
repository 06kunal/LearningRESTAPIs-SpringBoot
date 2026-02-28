package com.Project.Leaning.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDto {
    @NotBlank(message = "name is required")
    @Size(min = 3, max = 30, message = "name should be of minimum 3 to 30 characters")
    private String name;

    @Email
    @NotBlank(message = "email is Required")
    private String email;

    private String phone;

    private String address;

    @NotBlank
    private String password;

    @NotBlank
    private String password2;

}
