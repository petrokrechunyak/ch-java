package org.example.hibernate.DAO;

import org.example.hibernate.model.Chat;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ChatDaoImpl extends AbstractDao<Chat> implements ChatDao {

    @Override
    public Chat usersByChatId(UUID id) {
        Chat chat = findById(id);
//        Hibernate.initialize(chat.getUsers());
        return chat;
    }

    @Override
    public Chat findByCode(String code) {
        return getSession().createQuery("FROM Chat WHERE code=:chatCode", Chat.class)
                .setParameter("chatCode", code)
                .uniqueResult();
    }
}
