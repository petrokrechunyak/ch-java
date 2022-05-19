package org.example.hibernate.service;

import net.bytebuddy.utility.RandomString;
import org.example.hibernate.DAO.ChatDao;
import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.mapper.ChatMapper;
import org.example.hibernate.model.Chat;
import org.example.hibernate.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatDao chatDao;

    public ChatServiceImpl(ChatDao chatDao){
        this.chatDao = chatDao;
    }

    @Transactional
    @Override
    public ChatDTO save(ChatDTO chatDTO) {
        chatDTO.setCode(generateCode());
        chatDao.save(ChatMapper.INSTANCE.ChatDTOToChat(chatDTO));
        return chatDTO;
    }

    @Transactional
    public ChatDTO update(ChatDTO chatDTO) {
        Chat chat = ChatMapper.INSTANCE.ChatDTOToChat(chatDTO);
        return ChatMapper.INSTANCE.ChatToChatDTO(chat);
    }


    @Transactional
    @Override
    public void deleteById(UUID id) {
        chatDao.deleteById(id);
    }

    @Transactional
    @Override
    public List<ChatDTO> findAll() {
        return ChatMapper.INSTANCE.ChatToChatDTOList(chatDao.findAll());
    }

    @Override
    public ChatDTO findById(UUID id) {
        return ChatMapper.INSTANCE.ChatToChatDTO(chatDao.findById(id));
    }

    @Override
    public List<User> usersByChatId(UUID id) {
        return null;
    }

    @Override
    public ChatDTO findByCode(String code) {
        return ChatMapper.INSTANCE.ChatToChatDTO(chatDao.findByCode(code));
    }

    private String generateCode(){
        SimpleDateFormat format = new SimpleDateFormat("HHmmMMYYDDssSSS");
        Date date = new Date();
        return (format.format(date) + RandomString.make(5));
    }
}
