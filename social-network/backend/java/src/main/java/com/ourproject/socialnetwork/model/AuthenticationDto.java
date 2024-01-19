package com.ourproject.socialnetwork.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDto(
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotNull
        @Size(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16")
        String password
) {
}
