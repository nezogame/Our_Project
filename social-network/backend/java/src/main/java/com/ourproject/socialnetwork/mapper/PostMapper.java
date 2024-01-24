package com.ourproject.socialnetwork.mapper;

import com.ourproject.socialnetwork.entity.Post;
import com.ourproject.socialnetwork.model.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);


    PostDto postToPostDto(Post post);
}
