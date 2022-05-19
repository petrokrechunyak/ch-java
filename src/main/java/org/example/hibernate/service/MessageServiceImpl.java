package org.example.hibernate.service;

import org.example.hibernate.DAO.MessageDao;
import org.example.hibernate.DTO.MessageDTO;
import org.example.hibernate.mapper.MessageMapper;
import org.example.hibernate.mapper.UserMapper;
import org.example.hibernate.model.Message;
import org.example.hibernate.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageDao messageDao;

    public MessageServiceImpl(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<MessageDTO> findAll() {
        return MessageMapper.INSTANCE.messageToMessageDTOList(messageDao.findAll());
    }

    @Override
    public MessageDTO findById(UUID id) {
        Message message = messageDao.findById(id);
        return MessageMapper.INSTANCE.messageToMessageDTO(message);
    }

    @Transactional
    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        Message message = MessageMapper.INSTANCE.messageDTOToMessage(messageDTO);
        Message createdMessage = messageDao.save(message);
        return MessageMapper.INSTANCE.messageToMessageDTO(createdMessage);
    }

    @Transactional
    @Override
    public MessageDTO update(MessageDTO messageDTO) {
        Message message = MessageMapper.INSTANCE.messageDTOToMessage(messageDTO);
        return MessageMapper.INSTANCE.messageToMessageDTO(messageDao.update(message));
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        messageDao.deleteById(id);
    }
}
