package org.example.hibernate.service;

import org.example.hibernate.DAO.UserDao;
import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.mapper.UserMapper;
import org.example.hibernate.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<UserDTO> findAll() {
        return UserMapper.INSTANCE.userToUserDTOList(userDao.findAll());
    }

    @Transactional
    @Override
    public UserDTO findById(UUID id) {
        User user = userDao.findById(id);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Transactional
    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        User createdUser = userDao.save(user);
        return UserMapper.INSTANCE.userToUserDTO(createdUser);
    }

    @Transactional
    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        return UserMapper.INSTANCE.userToUserDTO(userDao.update(user));
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        userDao.deleteById(id);
    }
}
