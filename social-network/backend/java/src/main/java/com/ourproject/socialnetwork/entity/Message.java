package com.ourproject.socialnetwork.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Messages")
public class Message {
    @Transient
    public static final String SEQUENCE_NAME = "messages_sequence";
    @Id
    private Long messageId;
    @NotEmpty(message = "Message must have a time")
    @Field("message_time")
    private ZonedDateTime messageTime;
    @NotBlank(message = "Message must have a sender")
    @Field("sender_id")
    private String senderId;
    @NotBlank(message = "Message must be sent in chat")
    @Field("chat_id")
    private String chatId;
    @Field("edit")
    private Boolean edit;
}
