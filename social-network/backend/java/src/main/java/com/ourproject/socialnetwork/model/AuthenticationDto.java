package com.ourproject.socialnetwork.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public record AuthenticationDto(
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotNull
        @Range(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16")
        String password
) {
}
