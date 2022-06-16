package org.example.hibernate.DAO;

import org.example.hibernate.model.ChatUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class ChatUserDaoImpl extends AbstractDao<ChatUser> implements ChatUserDao {

    @Transactional
    @Override
    public List<ChatUser> chatsByUserId(UUID id) {
        return (List<ChatUser>) getSession().createQuery("FROM ChatUser WHERE user.id=:id")
                .setParameter("id", id).getResultList();
    }

    @Override
    public ChatUser chatUserByChatAndUser(String chatcode, UUID userId) {
        return (ChatUser) getSession().createQuery("FROM ChatUser WHERE user.id=:userid AND chat.code=:chatcode")
                .setParameter("userid", userId)
                .setParameter("chatcode", chatcode)
                .uniqueResult();
    }

    @Override
    public List<ChatUser> usersByChatCode(String code) {
        return (List<ChatUser>) getSession().createQuery("FROM ChatUser WHERE chat.code=:code")
                .setParameter("code", code).getResultList();
    }
}
