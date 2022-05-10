package org.example.hibernate.service;

import org.example.hibernate.DAO.BaseDao;
import org.example.hibernate.model.Chat;

import java.util.UUID;

public interface ChatService extends BaseDao<Chat> {

    Chat usersByChatId(UUID id);

    Chat findByCode(String code);
}
