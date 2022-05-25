package org.example.hibernate.mapper;

import org.example.hibernate.DTO.ChatUserDTO;
import org.example.hibernate.model.ChatUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatUserMapper {

    @Mappings({
            @Mapping(target = "userId", source = "chatUser.user.id"),
            @Mapping(target = "chatId", source = "chatUser.chat.id")
    })
    ChatUserDTO chatUserToChatUserDTO(ChatUser chatUser);

    @Mappings({
            @Mapping(target = "user.id", source = "chatUserDTO.userId"),
            @Mapping(target = "chat.id", source = "chatUserDTO.chatId")
    })
    ChatUser chatUserDTOToChatUser(ChatUserDTO chatUserDTO);

    List<ChatUserDTO> chatUserToChatUserDTOList(List<ChatUser> chatUserList);

}
