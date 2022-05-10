package org.example.hibernate.DAO;

import org.example.hibernate.model.Chat;
import org.example.hibernate.service.BaseService;

import java.util.UUID;


public interface ChatDao extends BaseService<Chat> {
    Chat usersByChatId(UUID id);

    Chat findByCode(String code);
}
