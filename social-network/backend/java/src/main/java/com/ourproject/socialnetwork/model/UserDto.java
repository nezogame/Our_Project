package com.ourproject.socialnetwork.model;

public record UserDto(
        String userName,
        String sex,
        String followers,
        String following,
        String userBio,
        String dob,
        String joinDate) {
}