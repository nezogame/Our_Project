package com.ourproject.socialnetwork.entity;


import com.ourproject.socialnetwork.config.Role;
import com.ourproject.socialnetwork.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "Users")
public class User implements UserDetails {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Long userId;
    @Field("user_role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Field("post_id")
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'user_id':?#{#self._id} }")
    private List<Post> postId;
    @Field("chat_id")
    @ReadOnlyProperty
    @DocumentReference(lookup = "{'user_id':?#{#self._id} }")
    private List<Chat> chatId;
    @Field("user_name")
    @Indexed(unique = true)
    private String username;
    @Field("mail")
    @Indexed(unique = true)
    private String mail;
    @Field("gender")
    private Gender gender;
    @Field("photo_ptr")
    private String photoPtr;
    @Field("followers")
    @Min(value = 0, message = "A user cannot have less than 0 followers")
    private Integer followers;
    @Field("following")
    @Min(value = 0, message = "A user cannot have less than 0 following")
    private Integer following;
    @Field("user_bio")
    private String userBio;
    @Field("date_of_birth")
    private Date dob;
    @Field("join_date")
    private Date joinDate;
    @Field("password")
    @Indexed(unique = true)
    @NotNull
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
