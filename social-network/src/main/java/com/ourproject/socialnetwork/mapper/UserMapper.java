package com.ourproject.socialnetwork.mapper;

import com.ourproject.socialnetwork.entity.User;
import com.ourproject.socialnetwork.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class);
    @Mapping(source = "joinDate", target = "joinDate", dateFormat = "dd.MM.yyyy")
    @Mapping(source = "dbo", target = "dbo", dateFormat = "dd.MM.yyyy")
    User userDtoToUser(UserDto entity);

    @Mapping(source = "joinDate", target = "joinDate", dateFormat = "dd.MM.yyyy")
    @Mapping(source = "dbo", target = "dbo", dateFormat = "dd.MM.yyyy")
    User userToUserDto(User entity);
}
