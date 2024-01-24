package com.ourproject.socialnetwork.entity;

import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Chats")
public class Chat {
    @Transient
    public static final String SEQUENCE_NAME = "chats_sequence";
    @Id
    private Long chatId;
    @NotEmpty(message = "Chat must have a name")
    @Field("name")
    @Indexed(unique = true)
    private String name;
    @NotBlank(message = "Chat must be group or personal")
    @Field("group")
    private boolean group;
    @Field("chat_photo")
    private String chatPhoto;
    @Field("user_id")
    Set<Long> participantIds;
}
