package com.ourproject.socialnetwork.model;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public record UserDto(
        Long userId,
        String username,
        String password,
        String mail,
        String sex,
        Long postId,
        Long chatId,
        String photoPtr,
        String followers,
        String following,
        String userBio,
        String dob,
        String joinDate) {
}