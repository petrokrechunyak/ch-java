package org.example.hibernate.mapper;

import org.example.hibernate.DTO.MessageDTO;
import org.example.hibernate.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    @Mappings({
            @Mapping(source = "message.chatUser.user", target = "userDTO")
    })
    MessageDTO messageToMessageDTO(Message message);

    @Mappings({
            @Mapping(source = "messageDTO.userDTO", target = "chatUser.user"),
            @Mapping(source = "messageDTO.chatUserId", target = "chatUser.id")
    })
    Message messageDTOToMessage(MessageDTO messageDTO);

    List<MessageDTO> messageToMessageDTOList(List<Message> messageList);

}
