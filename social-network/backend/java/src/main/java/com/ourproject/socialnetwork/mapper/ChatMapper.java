package com.ourproject.socialnetwork.mapper;

import com.ourproject.socialnetwork.entity.Chat;
import com.ourproject.socialnetwork.model.ChatDto;
import com.ourproject.socialnetwork.model.SaveChatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);


    Chat saveChatDtoToChat(SaveChatDto chat);

    ChatDto chatToChatDto(Chat chat);
}
