package com.ourproject.socialnetwork.mapper;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.model.AuthenticationDto;
import com.ourproject.socialnetwork.model.RegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "dob", target = "dob", dateFormat = "dd.MM.yyyy")
    User registerDtoToUser(RegisterDto entity);

    User authenticationDtoToUser(AuthenticationDto entity);

}
