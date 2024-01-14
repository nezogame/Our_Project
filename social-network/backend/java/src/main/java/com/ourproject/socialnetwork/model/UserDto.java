package com.ourproject.socialnetwork.model;

import com.ourproject.socialnetwork.enums.Gender;
import com.ourproject.socialnetwork.entity.Chat;
import com.ourproject.socialnetwork.entity.Post;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record UserDto(
        Long userId,
        @NotBlank(message = "Username can't be empty")
        String username,
        @NotNull
        @Size(min = 4, max = 16, message = "password should have at least 4 characters and maximum 16" )
        String password,
        @Email
        @NotEmpty(message = "Email can't be empty")
        String mail,
        Gender sex,
        List<Post> postId,
        List<Chat> chatId,
        String photoPtr,
        String followers,
        String following,
        String userBio,
        String dob,
        String joinDate) {
}