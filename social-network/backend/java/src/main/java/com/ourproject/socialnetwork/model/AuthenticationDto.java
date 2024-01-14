package com.ourproject.socialnetwork.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public record AuthenticationDto(
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotNull
        @Size(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16")
        String password
) {
}
