package org.example.hibernate.controller;

import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/{id}")
    public ChatDTO findById(@PathVariable("id") UUID id){
        return chatService.findById(id);
    }

    @GetMapping
    public List<ChatDTO> findAll(){
        return chatService.findAll();
    }

    @PostMapping
    public ChatDTO save(@RequestBody ChatDTO chatDTO){
        return chatService.save(chatDTO);
    }

    @PutMapping
    public ChatDTO update(@RequestBody ChatDTO chat){
        return chatService.update(chat);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody UUID id){
        chatService.deleteById(id);
    }

}
