package com.ourproject.socialnetwork.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
    @NotBlank(message = "Chat must be group or personal")
    @Field("group")
    private boolean group;
    @Field("chat_photo")
    private boolean chatPhoto;
}
