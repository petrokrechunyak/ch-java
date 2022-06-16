package org.example.hibernate.controller;

import org.example.hibernate.DAO.ChatDao;
import org.example.hibernate.DAO.ChatUserDao;
import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.ChatUserDTO;
import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.DTO.UserWithChatsDTO;
import org.example.hibernate.mapper.ChatMapper;
import org.example.hibernate.mapper.ChatUserMapper;
import org.example.hibernate.model.Chat;
import org.example.hibernate.model.User;
import org.example.hibernate.service.ChatUserService;
import org.example.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    ChatUserService chatUserService;
    @Autowired
    ChatMapper chatMapper;

    public UserController(UserService userService, ChatUserService chatUserService) {
        this.userService = userService;
        this.chatUserService = chatUserService;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable("id") UUID id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}/chats")
    public List<ChatDTO> findWithChats(@PathVariable UUID id){
        List<Chat> chats = new ArrayList<>();
        chatUserService.chatsByUserId(id).forEach(x -> chats.add(x.getChat()));
        return chatMapper.chatToChatDTOList(chats);
    }


}
