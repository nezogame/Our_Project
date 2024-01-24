package com.ourproject.socialnetwork.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import org.hibernate.validator.constraints.Range;

public record RegisterDto(
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotEmpty(message = "Email can't be empty")
        @Email
        String mail,
        @NotNull
        @Range(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16")
        String password,
        boolean sex,
        Date dob
) {

}
