package org.example.hibernate.service;

import net.bytebuddy.utility.RandomString;
import org.example.hibernate.DAO.ChatDao;
import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.ChatWithMessagesDTO;
import org.example.hibernate.mapper.ChatMapper;
import org.example.hibernate.model.Chat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatDao chatDao;
    private ChatMapper chatMapper;

    public ChatServiceImpl(ChatDao chatDao, ChatMapper chatMapper) {
        this.chatDao = chatDao;
        this.chatMapper = chatMapper;
    }

    @Transactional
    @Override
    public ChatDTO save(ChatDTO chatDTO) {
        chatDTO.setCode(generateCode());
        chatDao.save(chatMapper.chatDTOToChat(chatDTO));
        return chatDTO;
    }

    @Transactional
    public ChatDTO update(ChatDTO chatDTO) {
        Chat chat = chatMapper.chatDTOToChat(chatDTO);
        return chatMapper.chatToChatDTO(chat);
    }


    @Transactional
    @Override
    public ChatDTO deleteById(UUID id) {
        return chatMapper.chatToChatDTO(chatDao.deleteById(id));
    }

    public Chat chatWithMessages(UUID id) {
//        Chat chat = findById(id);
return new Chat();
    }

    @Transactional
    @Override
    public List<ChatDTO> findAll() {
        return chatMapper.chatToChatDTOList(chatDao.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public ChatDTO findById(UUID id) {
        return chatMapper.chatToChatDTO(chatDao.findById(id));
    }

    @Override
    public ChatWithMessagesDTO findChatWithMessages(UUID id) {
        Chat chat = chatDao.findById(id);

        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public ChatDTO findByCode(String code) {
        return chatMapper.chatToChatDTO(chatDao.findByCode(code));
    }

    private String generateCode() {
        return new Date().getTime() + RandomString.make(5);
    }
}
