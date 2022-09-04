package org.example.hibernate.DAO;

import org.example.hibernate.model.ChatUser;
import org.example.hibernate.model.Message;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Message> findPageByCode(String code, int present) {
        int max = 5;
        long count = (long) getSession().createQuery("SELECT COUNT(*) FROM messages AS m WHERE m.chatUser.chat.code=:chatCode")
                .setParameter("chatCode", code)
                .uniqueResult();
        long skip = count - present - max;
        if(skip < 0) {
            skip = 0;
            max = (int) count % present;
        }
        return getSession().createQuery("FROM messages AS m WHERE m.chatUser.chat.code=:chatCode")
                .setFirstResult((int) skip)
                .setMaxResults(max)
                .setParameter("chatCode", code)
                .getResultList();
    }

    @Override
    public List<Message> findByCode(String code) {
        return getSession().createQuery("FROM messages AS m WHERE m.chatUser.chat.code=:chatCode")
                .setParameter("chatCode", code)
                .getResultList();
    }
}
