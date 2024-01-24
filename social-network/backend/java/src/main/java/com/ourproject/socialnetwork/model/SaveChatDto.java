package com.ourproject.socialnetwork.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

public record SaveChatDto(
        @NotEmpty(message = "Chat must have a name")
        String name,
        @NotNull(message = "You must specify it group chat or personal")
        Boolean group,
        String chatPhoto,
        @NotNull(message = "You must pass id of user(s) that have this chat")
        Set<Long> userId
) {

}
