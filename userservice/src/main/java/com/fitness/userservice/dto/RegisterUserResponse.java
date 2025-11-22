package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserResponse {
    private String firstName;
    private String lastname;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be of correct format")
    private String email;

    @NotBlank(message = "password cannot be empty")
    @Size(min = 6,message = "pass must be 6 characters long")
    private String password;
}
