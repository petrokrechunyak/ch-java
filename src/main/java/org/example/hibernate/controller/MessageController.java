package org.example.hibernate.controller;

import org.example.hibernate.DAO.MessageDao;
import org.example.hibernate.DTO.MessageDTO;
import org.example.hibernate.model.Message;
import org.example.hibernate.service.ChatUserService;
import org.example.hibernate.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
public class MessageController {

    MessageService messageService;

    ChatUserService chatUserService;

    public MessageController(MessageService messageService, ChatUserService chatUserService) {
        this.messageService = messageService;
        this.chatUserService = chatUserService;
    }

    @GetMapping("/{id}")
    public MessageDTO findById(@PathVariable("id") UUID id) {
        return messageService.findById(id);
    }

    @GetMapping
    public List<MessageDTO> findAll() {
        return messageService.findAll();
    }

    @PostMapping
    public MessageDTO save(@RequestBody MessageDTO messageDTO) {
        return messageService.save(messageDTO);
    }

    @PutMapping
    public MessageDTO update(@RequestBody MessageDTO messageDTO) {
        return messageService.update(messageDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody UUID id) {
        messageService.deleteById(id);
    }

    @GetMapping("/{code}/{present}")
    public List<MessageDTO> getPageByCode(@PathVariable String code, @PathVariable int present){
        return messageService.findPageByCode(code, present);
    }

}
