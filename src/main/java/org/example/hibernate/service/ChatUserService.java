package org.example.hibernate.service;

import org.example.hibernate.DTO.ChatUserDTO;
import org.example.hibernate.model.ChatUser;

import java.util.List;
import java.util.UUID;

public interface ChatUserService extends BaseService<ChatUserDTO> {

    List<ChatUser> chatsByUserId(UUID id);

    ChatUserDTO chatUserByChatAndUser(String chatId, UUID userId);

}
