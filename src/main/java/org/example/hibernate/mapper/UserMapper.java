package org.example.hibernate.mapper;

import org.example.hibernate.DTO.UserDTO;
import org.example.hibernate.DTO.UserWithChatsDTO;
import org.example.hibernate.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    List<UserDTO> userToUserDTOList(List<User> userList);

    UserWithChatsDTO usertoUserWithChatsDTO(User user);

}
