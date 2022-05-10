package org.example.hibernate.DAO;

import org.example.hibernate.model.Message;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {
}
