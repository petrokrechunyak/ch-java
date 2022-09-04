package org.example.hibernate.DAO;

import org.example.hibernate.model.Chat;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDaoImpl extends AbstractDao<Chat> implements ChatDao {

    @Override
    public Chat findByCode(String code) {
        return getSession().createQuery("FROM Chat WHERE code=:chatCode", Chat.class)
                .setParameter("chatCode", code)
                .uniqueResult();
    }

    @Override
    public Chat save(Chat chat) {
        super.save(chat);
        return findByCode(chat.getCode());
    }
}
