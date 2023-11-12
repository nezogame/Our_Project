package com.ourproject.socialnetwork.mapper;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.model.AuthenticationDto;
import com.ourproject.socialnetwork.model.RegisterDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T15:37:29+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User registerDtoToUser(RegisterDto entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.dob( entity.dob() );
        user.username( entity.username() );
        user.mail( entity.mail() );
        user.sex( entity.sex() );
        user.password( entity.password() );

        return user.build();
    }

    @Override
    public User authenticationDtoToUser(AuthenticationDto entity) {
        if ( entity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( entity.username() );
        user.password( entity.password() );

        return user.build();
    }
}
