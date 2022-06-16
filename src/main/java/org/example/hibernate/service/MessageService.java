package org.example.hibernate.service;

import org.example.hibernate.DTO.MessageDTO;
import org.example.hibernate.model.Message;

import java.util.List;

public interface MessageService extends BaseService<MessageDTO> {

    List<MessageDTO> findByCode(String code);

    List<MessageDTO> findPageByCode(String code, int present);

}
