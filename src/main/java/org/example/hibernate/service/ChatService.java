package org.example.hibernate.service;

import org.example.hibernate.DAO.BaseDao;
import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.model.Chat;
import org.example.hibernate.model.User;

import java.util.List;
import java.util.UUID;

public interface ChatService extends BaseDao<ChatDTO> {

    List<User> usersByChatId(UUID id);

    ChatDTO findByCode(String code);
}
