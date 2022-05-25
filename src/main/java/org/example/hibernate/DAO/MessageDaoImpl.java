package org.example.hibernate.DAO;

import org.example.hibernate.model.ChatUser;
import org.example.hibernate.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {
    ChatUserDao chatUserDao;
    ChatDao chatDao;

    public MessageDaoImpl(ChatUserDao chatUserDao, ChatDao chatDao) {
        this.chatUserDao = chatUserDao;
        this.chatDao = chatDao;
    }

    @Override
    public List<Message> findByCode(String code) {
        return getSession().createQuery("FROM messages AS m WHERE m.chatUser.chat.code=:chatCode")
                .setParameter("chatCode", code)
                .getResultList();
    }
}
