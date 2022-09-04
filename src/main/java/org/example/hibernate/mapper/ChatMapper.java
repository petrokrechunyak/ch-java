package org.example.hibernate.mapper;

import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.DTO.ChatWithMessagesDTO;
import org.example.hibernate.model.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatDTO chatToChatDTO(Chat Chat);

//    @Mappings({
//            @Mapping(source = "chat.id", target = "id"),
//            @Mapping(source = "chat.code", target = "code"),
//            @Mapping(source = "chat.title", target = "titile"),
//    })
    ChatWithMessagesDTO chatToChatWithMessagesDTO(ChatDTO chat);

    Chat chatDTOToChat(ChatDTO ChatDTO);

    List<ChatDTO> chatToChatDTOList(List<Chat> ChatList);


}
