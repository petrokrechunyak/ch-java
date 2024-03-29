package org.example.hibernate.DAO;

import org.example.hibernate.model.ChatUser;
import org.example.hibernate.model.Message;

import java.util.List;

public interface MessageDao extends BaseDao<Message> {
    List<Message> findPageByCode(String code, int present);

    List<Message> findByCode(String code);
}
