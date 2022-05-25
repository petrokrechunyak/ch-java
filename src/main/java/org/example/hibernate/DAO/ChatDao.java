package org.example.hibernate.DAO;

import org.example.hibernate.model.Chat;
import org.example.hibernate.service.BaseService;


public interface ChatDao extends BaseService<Chat> {

    Chat findByCode(String code);
}
