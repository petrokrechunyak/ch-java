package org.example.hibernate.mapper;

import org.example.hibernate.DTO.ChatDTO;
import org.example.hibernate.model.Chat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChatMapper {

    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    ChatDTO ChatToChatDTO(Chat Chat);

    Chat ChatDTOToChat(ChatDTO ChatDTO);

    List<ChatDTO> ChatToChatDTOList(List<Chat> ChatList);

}
