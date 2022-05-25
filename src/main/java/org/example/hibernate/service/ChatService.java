package org.example.hibernate.service;

import org.example.hibernate.DAO.BaseDao;
import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.ChatWithMessagesDTO;

import java.util.UUID;

public interface ChatService extends BaseDao<ChatDTO> {

    ChatWithMessagesDTO findChatWithMessages(UUID id);

    ChatDTO findByCode(String code);
}
