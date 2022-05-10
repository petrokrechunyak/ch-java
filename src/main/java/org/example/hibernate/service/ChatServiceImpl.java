package org.example.hibernate.service;

import net.bytebuddy.utility.RandomString;
import org.example.hibernate.DAO.ChatDao;
import org.example.hibernate.model.Chat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    ChatDao chatDao;

    public ChatServiceImpl(ChatDao chatDao){
        this.chatDao = chatDao;
    }

    @Override
    public Chat save(Chat chat) {
        do {
            chat.setCode(RandomString.make(Chat.CODE_LENGTH));
        } while (findByCode(chat.getCode()) != null);
        chatDao.save(chat);
        return chat;
    }

    public Chat update(Chat chat) {
        chatDao.update(chat);
        return chat;
    }

    @Override
    public void delete(Chat chat) {
        chatDao.delete(chat);
    }

    @Override
    public void deleteById(UUID id) {
        chatDao.deleteById(id);
    }

    @Override
    public List<Chat> findAll() {
        return chatDao.findAll();
    }

    @Override
    public Chat findById(UUID id) {
        return chatDao.findById(id);
    }

    @Override
    public Chat usersByChatId(UUID id) {
        return chatDao.usersByChatId(id);
    }

    @Override
    public Chat findByCode(String code) {
        return chatDao.findByCode(code);
    }
}
