package org.example.hibernate.service;

import org.example.hibernate.DTO.MessageDTO;

import java.util.List;

public interface MessageService extends BaseService<MessageDTO> {

    List<MessageDTO> findByCode(String code);

}
