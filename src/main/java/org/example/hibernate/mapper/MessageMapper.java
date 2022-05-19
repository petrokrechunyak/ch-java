package org.example.hibernate.mapper;

import org.example.hibernate.DTO.MessageDTO;
import org.example.hibernate.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDTO messageToMessageDTO(Message Message);

    Message messageDTOToMessage(MessageDTO MessageDTO);

    List<MessageDTO> messageToMessageDTOList(List<Message> MessageList);

}
