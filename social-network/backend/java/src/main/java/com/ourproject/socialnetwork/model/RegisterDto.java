package com.ourproject.socialnetwork.model;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record RegisterDto(
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotEmpty(message = "Email can't be empty")
        @Email
        String mail,
        @NotNull
        @Size(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16" )
        String password,
        boolean sex,
        Date dob
) {

}
