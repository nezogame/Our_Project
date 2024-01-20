package com.ourproject.socialnetwork.model;

import com.ourproject.socialnetwork.config.Role;
import com.ourproject.socialnetwork.enums.Gender;
import com.ourproject.socialnetwork.entity.Chat;
import com.ourproject.socialnetwork.entity.Post;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotNull
        Long userId,
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotNull
        @Size(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16" )
        String password,
        @Email
        @NotEmpty(message = "Email can't be empty")
        String mail,
        Gender gender,
        List<Post> postId,
        List<Chat> chatId,
        String photoPtr,
        Integer followers,
        Integer following,
        String userBio,
        String dob,
        String joinDate,
        Role role) {
}