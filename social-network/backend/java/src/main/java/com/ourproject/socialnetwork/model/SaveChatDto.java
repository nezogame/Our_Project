package com.ourproject.socialnetwork.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

public record SaveChatDto(
        @NotEmpty(message = "Chat must have a name")
        String name,
        @NotNull(message = "You must specify it group chat or personal")
        Boolean group,
        String chatPhoto,
        @Size(min = 2, message = "You must pass id of users that have this chat, minimum 2 user for chat")
        Set<Long> userId
) {

}
