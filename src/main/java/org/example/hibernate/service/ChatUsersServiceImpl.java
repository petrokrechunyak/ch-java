package org.example.hibernate.service;

import org.example.hibernate.DAO.ChatUserDao;
import org.example.hibernate.model.ChatUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ChatUsersServiceImpl implements ChatUserService{

    private ChatUserDao chatUserDao;

    public ChatUsersServiceImpl(ChatUserDao chatUserDao) {
        this.chatUserDao = chatUserDao;
    }

    @Transactional
    @Override
    public List<ChatUser> findAll() {
        return chatUserDao.findAll();
    }

    @Transactional
    @Override
    public ChatUser findById(UUID id) {
        return chatUserDao.findById(id);
    }

    @Transactional
    @Override
    public ChatUser save(ChatUser chatUser) {
        chatUserDao.save(chatUser);
        return chatUser;
    }

    @Transactional
    @Override
    public ChatUser update(ChatUser chatUser) {
        chatUserDao.update(chatUser);
        return chatUser;
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        chatUserDao.deleteById(id);
    }
}
