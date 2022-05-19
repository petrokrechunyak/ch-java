package org.example.hibernate.DAO;

import org.example.hibernate.model.ChatUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ChatUserDaoImpl extends AbstractDao<ChatUser> implements ChatUserDao{

}
