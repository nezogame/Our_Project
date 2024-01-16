package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    private final SequenceGeneratorService userSequenceService;
}
