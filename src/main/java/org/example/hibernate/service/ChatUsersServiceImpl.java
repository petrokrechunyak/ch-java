package org.example.hibernate.service;

import org.example.hibernate.DAO.ChatUserDao;
import org.example.hibernate.model.ChatUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChatUsersServiceImpl implements ChatUserService{

    private ChatUserDao chatUserDao;

    public ChatUsersServiceImpl(ChatUserDao chatUserDao) {
        this.chatUserDao = chatUserDao;
    }

    @Override
    public List<ChatUser> findAll() {
        return chatUserDao.findAll();
    }

    @Override
    public ChatUser findById(UUID id) {
        return chatUserDao.findById(id);
    }

    @Override
    public ChatUser save(ChatUser chatUser) {
        chatUserDao.save(chatUser);
        return chatUser;
    }

    @Override
    public ChatUser update(ChatUser chatUser) {
        chatUserDao.update(chatUser);
        return chatUser;
    }

    @Override
    public void delete(ChatUser chatUser) {
        chatUserDao.delete(chatUser);
    }

    @Override
    public void deleteById(UUID id) {
        chatUserDao.deleteById(id);
    }
}
