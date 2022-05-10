package org.example.hibernate.service;

import org.example.hibernate.DAO.MessageDao;
import org.example.hibernate.model.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{

    MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message findById(UUID id) {
        return messageDao.findById(id);
    }

    @Override
    public Message save(Message Message) {
        messageDao.save(Message);
        return Message;
    }

    @Override
    public Message update(Message Message) {
        messageDao.update(Message);
        return Message;
    }

    @Override
    public void delete(Message Message) {
        messageDao.delete(Message);
    }

    @Override
    public void deleteById(UUID id) {
        messageDao.deleteById(id);
    }
}
