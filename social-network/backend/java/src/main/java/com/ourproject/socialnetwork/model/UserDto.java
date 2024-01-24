package com.ourproject.socialnetwork.model;

import com.ourproject.socialnetwork.config.Role;
import com.ourproject.socialnetwork.entity.Chat;
import com.ourproject.socialnetwork.entity.Post;
import com.ourproject.socialnetwork.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public record UserDto(
        @NotNull(message = "User id can't be empty")
        Long userId,
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotNull
        @Size(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16")
        String password,
        @Email
        @NotEmpty(message = "Email can't be empty")
        String mail,
        Gender gender,
        List<Post> postId,
        List<Chat> chatId,
        String photoPtr,
        @Min(value = 0, message = "A user cannot have less than 0 followers")
        Integer followers,
        @Min(value = 0, message = "A user cannot have less than 0 following")
        Integer following,
        String userBio,
        String dob,
        String joinDate,
        Role role) {
}