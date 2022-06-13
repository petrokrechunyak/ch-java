package org.example.hibernate.DAO;

import org.example.hibernate.model.Chat;
import org.example.hibernate.model.ChatUser;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ChatUserDao extends BaseDao<ChatUser> {
    List<ChatUser> chatsByUserId(UUID id);

    ChatUser chatUserByChatAndUser(String chatcode, UUID userId);
}
