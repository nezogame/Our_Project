package com.ourproject.socialnetwork.controller;

import com.ourproject.socialnetwork.model.ChatDto;
import com.ourproject.socialnetwork.model.SaveChatDto;
import com.ourproject.socialnetwork.service.ChatService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social-network")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/create-chat")
    public ResponseEntity<ChatDto> createChat(@Valid @RequestBody SaveChatDto chatForSave) {
        return new ResponseEntity<>(chatService.createChat(chatForSave), HttpStatus.OK);
    }

    @GetMapping("/get-chats")
    public ResponseEntity<List<ChatDto>> getAllChats() {
        return new ResponseEntity<>(chatService.findAllChats(), HttpStatus.OK);
    }

    @PutMapping("/update-chat")
    public ResponseEntity<ChatDto> updateChat(@Valid @RequestBody ChatDto chatForUpdate) {
        return new ResponseEntity<>(chatService.updateChat(chatForUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete-chat/{chatId}")
    public ResponseEntity<Void> deleteChat(@PathVariable Long chatId){
        chatService.deleteUser(chatId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

/*    @GetMapping("/chats")
    public ResponseEntity<List<ChatDto>> getUserChats() {
        return new ResponseEntity<>(chatService.findUserChats(), HttpStatus.OK);
    }*/
}
