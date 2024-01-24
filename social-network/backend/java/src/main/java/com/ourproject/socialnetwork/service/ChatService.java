package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.entity.Chat;
import com.ourproject.socialnetwork.mapper.ChatMapper;
import com.ourproject.socialnetwork.model.ChatDto;
import com.ourproject.socialnetwork.model.SaveChatDto;
import com.ourproject.socialnetwork.repository.ChatRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    private final SequenceGeneratorService chatSequenceService;

    public List<ChatDto> findAllChats() {
        var chats = chatRepository.findAll();
        return chats.stream()
                .map(ChatMapper.INSTANCE::chatToChatDto)
                .toList();
    }

    public ChatDto createChat(SaveChatDto saveChatDto) {
        Chat chat = ChatMapper.INSTANCE.saveChatDtoToChat(saveChatDto);
        chat.setChatId(chatSequenceService.generateSequence(Chat.SEQUENCE_NAME));
        chat = chatRepository.save(chat);
        return ChatMapper.INSTANCE.chatToChatDto(chat);
    }
}
