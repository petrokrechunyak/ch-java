package org.example.hibernate.controller;

import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.ChatWithMessagesDTO;
import org.example.hibernate.DTO.MessageDTO;
import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.mapper.ChatMapper;
import org.example.hibernate.mapper.UserMapper;
import org.example.hibernate.model.Chat;
import org.example.hibernate.model.User;
import org.example.hibernate.service.ChatService;
import org.example.hibernate.service.ChatUserService;
import org.example.hibernate.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

    ChatService chatService;
    MessageService messageService;
    ChatMapper chatMapper;
    @Autowired
    ChatUserService chatUserService;
    @Autowired
    UserMapper userMapper;

    public ChatController(ChatService chatService, MessageService messageService, ChatMapper chatMapper) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.chatMapper = chatMapper;
    }

    @GetMapping("/{id}")
    public ChatDTO findById(@PathVariable("id") UUID id) {
        return chatService.findById(id);
    }

    @GetMapping
    public List<ChatDTO> findAll() {
        return chatService.findAll();
    }

    @GetMapping("/{code}/messages")
    public ChatWithMessagesDTO findByCode(@PathVariable("code") String code){
        ChatDTO chatDTO = chatService.findByCode(code);
        ChatWithMessagesDTO chatWithMessagesDTO = chatMapper
                .chatToChatWithMessagesDTO(chatDTO);
        chatWithMessagesDTO.setMessages(
                messageService.findByCode(code)
        );
        return chatWithMessagesDTO;
    }

    @PostMapping
    public ChatDTO save(@RequestBody ChatDTO chatDTO) {
        return chatService.save(chatDTO);
    }

    @PutMapping
    public ChatDTO update(@RequestBody ChatDTO chat) {
        return chatService.update(chat);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody UUID id) {
        chatService.deleteById(id);
    }

    @GetMapping("{code}/users")
    public List<UserDTO> usersByChatCode(@PathVariable String code){
        List<User> users = new ArrayList<>();
        chatUserService.usersByChatCode(code).forEach(x -> users.add(x.getUser()));
        return userMapper.userToUserDTOList(users);
    }
}
