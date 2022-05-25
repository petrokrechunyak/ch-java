package org.example.hibernate.service;

import org.example.hibernate.DAO.ChatUserDao;
import org.example.hibernate.DTO.ChatUserDTO;
import org.example.hibernate.mapper.ChatUserMapper;
import org.example.hibernate.model.ChatUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ChatUserServiceImpl implements ChatUserService {

    private ChatUserDao chatUserDao;
    private ChatUserMapper chatUserMapper;

    public ChatUserServiceImpl(ChatUserDao chatUserDao, ChatUserMapper chatUserMapper) {
        this.chatUserDao = chatUserDao;
        this.chatUserMapper = chatUserMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ChatUserDTO> findAll() {
        return chatUserMapper.chatUserToChatUserDTOList(chatUserDao.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public ChatUserDTO findById(UUID id) {
        return chatUserMapper.chatUserToChatUserDTO(chatUserDao.findById(id));
    }

    @Transactional
    @Override
    public ChatUserDTO save(ChatUserDTO chatUserDTO) {
        ChatUser savedChatUser = chatUserDao.save(chatUserMapper.chatUserDTOToChatUser(chatUserDTO));
        return chatUserMapper.chatUserToChatUserDTO(savedChatUser);
    }

    @Transactional
    @Override
    public ChatUserDTO update(ChatUserDTO chatUserDTO) {
        ChatUser updatedChatUser = chatUserDao.update(chatUserMapper.chatUserDTOToChatUser(chatUserDTO));
        return chatUserMapper.chatUserToChatUserDTO(updatedChatUser);
    }

    @Transactional
    @Override
    public ChatUserDTO deleteById(UUID id) {
        return chatUserMapper.chatUserToChatUserDTO(chatUserDao.deleteById(id));
    }
}
