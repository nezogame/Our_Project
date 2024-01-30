package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.config.JwtService;
import com.ourproject.socialnetwork.entity.Chat;
import com.ourproject.socialnetwork.mapper.ChatMapper;
import com.ourproject.socialnetwork.model.ChatDto;
import com.ourproject.socialnetwork.model.SaveChatDto;
import com.ourproject.socialnetwork.repository.ChatRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final JwtService jwtService;
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

    @Transactional
    public ChatDto updateChat(ChatDto chatDto) throws EntityNotFoundException {
        Chat chat = ChatMapper.INSTANCE.chatDtoToChat(chatDto);
        if (!chatRepository.existsById(chat.getChatId())) {
            throw new EntityNotFoundException("Chat not found with id: " + chat.getChatId());
        }
        chat = chatRepository.save(chat);
        return ChatMapper.INSTANCE.chatToChatDto(chat);
    }

    public void deleteUser(Long chatId) throws EntityNotFoundException {
        if (!chatRepository.existsById(chatId)) {
            throw new EntityNotFoundException("Chat with id: " + chatId + " not found");
        }
        chatRepository.deleteById(chatId);
    }

/*    public List<ChatDto> findUserChats(String token) {
        jwtService.extractUsername()
        return new ArrayList<>();
    }*/
}
