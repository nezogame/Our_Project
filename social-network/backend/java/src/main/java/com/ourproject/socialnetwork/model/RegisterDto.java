package com.ourproject.socialnetwork.model;

import java.util.Date;

public record RegisterDto(
        String username,
        String mail,
        String password,
        boolean sex,
        Date dob
) {

}
