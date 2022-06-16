package org.example.hibernate.service;

import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService extends BaseService<UserDTO> {

    User chatsByUserId(UUID id);

}
