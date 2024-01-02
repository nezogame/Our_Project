package com.ourproject.socialnetwork.entity;

import java.util.Date;
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
@Document(collection = "Posts")
public class Post   {
    @Transient
    public static final String SEQUENCE_NAME = "posts_sequence";
    @Id
    private Long postId;
    @Field("img")
    private String img;
    @Field("text_body")
    private String textBody;
    @Field("likes")
    private Long likes;
    @Field("dislikes")
    private Long dislikes;
    @Field("comments")
    private String comments;
    @Field("date_publication")
    @NotBlank(message = "Date of the Publication Must Be Present")
    private Date datePublication;
}
