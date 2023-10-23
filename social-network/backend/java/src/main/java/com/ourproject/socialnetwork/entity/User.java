package com.ourproject.socialnetwork.entity;


import java.time.LocalDate;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Component
@Document(collection ="Users")
public class User implements UserDetails {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    @Field("user_id")
    private Long userId;
    @Field("access_token")
    @Indexed(unique = true)
    private String accessToken;
    @Field("post_id")
    private Long postId;
    @Field("chat_id")
    private Long chatId;
    @Field("user_name")
    @Indexed(unique = true)
    private String username;
    @Field("mail")
    @Indexed(unique = true)
    private String mail;
    @Field("sex")
    private boolean sex;
    @Field("photo_ptr")
    private String photoPtr;
    @Field("followers")
    private Integer followers;
    @Field("following")
    private Integer following;
    @Field("user_bio")
    private String userBio;
    @Field("date_of_birth")
    private LocalDate dob;
    @Field("join_date")
    private LocalDate joinDate;
    @Field("password")
    @Indexed(unique = true)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
