package com.ourproject.socialnetwork.controller;

import com.ourproject.socialnetwork.model.ChatDto;
import com.ourproject.socialnetwork.model.SaveChatDto;
import com.ourproject.socialnetwork.model.UserDto;
import com.ourproject.socialnetwork.service.ChatService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social-network")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/create-chat")
    public ResponseEntity<ChatDto> update(@Valid @RequestBody SaveChatDto chatForSave) {
        return new ResponseEntity<>(chatService.createChat(chatForSave), HttpStatus.OK);
    }
}
