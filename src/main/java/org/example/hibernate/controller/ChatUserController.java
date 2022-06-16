package org.example.hibernate.controller;

import org.example.hibernate.DTO.ChatUserDTO;
import org.example.hibernate.service.ChatUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat-user")
public class ChatUserController {

    ChatUserService chatUserService;

    public ChatUserController(ChatUserService chatUserService) {
        this.chatUserService = chatUserService;
    }

    @GetMapping
    public List<ChatUserDTO> findAll() {
        return chatUserService.findAll();
    }

    @GetMapping("/{id}")
    public ChatUserDTO findById(@PathVariable("id") UUID id) {
        return chatUserService.findById(id);
    }

    @PostMapping
    public ChatUserDTO save(@RequestBody ChatUserDTO chatUserDTO) {
        return chatUserService.save(chatUserDTO);
    }

    @GetMapping("/byChatAndUser")
    public ChatUserDTO getByChatAndUser(@RequestParam String chat, @RequestParam String user){
        return chatUserService.chatUserByChatAndUser(
                chat,
                UUID.fromString(user)
        );
    }

}
