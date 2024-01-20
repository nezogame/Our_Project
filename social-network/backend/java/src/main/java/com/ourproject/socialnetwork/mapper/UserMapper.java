package com.ourproject.socialnetwork.mapper;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.model.RegisterDto;
import com.ourproject.socialnetwork.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "dob", target = "dob", dateFormat = "dd.MM.yyyy")
    User registerDtoToUser(RegisterDto entity);

    @Mapping(source = "dob", target = "dob", dateFormat = "dd.MM.yyyy")
    @Mapping(source = "joinDate", target = "joinDate", dateFormat = "dd.MM.yyyy")
    User UserDtoToUser(UserDto entity);

    @Mapping(source = "dob", target = "dob", dateFormat = "dd.MM.yyyy")
    @Mapping(source = "joinDate", target = "joinDate", dateFormat = "dd.MM.yyyy")
    UserDto UserToUserDto(User user);
}
