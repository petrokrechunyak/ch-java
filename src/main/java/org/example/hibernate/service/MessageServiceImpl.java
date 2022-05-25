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
    private MessageMapper messageMapper;

    public MessageServiceImpl(MessageDao messageDao, MessageMapper messageMapper) {
        this.messageDao = messageDao;
        this.messageMapper = messageMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MessageDTO> findAll() {
        return messageMapper.messageToMessageDTOList(messageDao.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public MessageDTO findById(UUID id) {
        Message message = messageDao.findById(id);
        return messageMapper.messageToMessageDTO(message);
    }

    @Transactional
    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        Message message = messageMapper.messageDTOToMessage(messageDTO);
        Message createdMessage = messageDao.save(message);
        return messageMapper.messageToMessageDTO(createdMessage);
    }

    @Transactional
    @Override
    public MessageDTO update(MessageDTO messageDTO) {
        Message message = messageMapper.messageDTOToMessage(messageDTO);
        return messageMapper.messageToMessageDTO(messageDao.update(message));
    }

    @Transactional
    @Override
    public MessageDTO deleteById(UUID id) {
        return messageMapper.messageToMessageDTO(messageDao.deleteById(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<MessageDTO> findByCode(String code) {
        return messageMapper.messageToMessageDTOList(messageDao.findByCode(code));
    }
}
