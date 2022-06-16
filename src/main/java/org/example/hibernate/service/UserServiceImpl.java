package org.example.hibernate.service;

import org.example.hibernate.DAO.UserDao;
import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.DTO.UserWithChatsDTO;
import org.example.hibernate.mapper.UserMapper;
import org.example.hibernate.model.ChatUser;
import org.example.hibernate.model.User;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserMapper userMapper;

    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> findAll() {
        return userMapper.userToUserDTOList(userDao.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public UserDTO findById(UUID id) {
        User user = userDao.findById(id);
        return userMapper.userToUserDTO(user);
    }

    @Transactional
    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User createdUser = userDao.save(user);
        return userMapper.userToUserDTO(createdUser);
    }

    @Transactional
    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        return userMapper.userToUserDTO(userDao.update(user));
    }

    @Transactional
    @Override
    public UserDTO deleteById(UUID id) {
       return userMapper.userToUserDTO(userDao.deleteById(id));
    }

    @Transactional(readOnly = true)
    @Override
    public User chatsByUserId(UUID id) {
        User user = userDao.findById(id);
        Set<ChatUser> chatUsers = new HashSet<>();
        Hibernate.initialize(chatUsers);
        user.setChatUser(chatUsers);
        return user;
    }
}
