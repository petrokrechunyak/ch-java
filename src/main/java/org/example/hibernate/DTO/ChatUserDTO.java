package org.example.hibernate.DTO;

import java.util.UUID;

public class ChatUserDTO {

    private UUID id;

    private UUID userId;

    private UUID chatId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "ChatUserDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", chatId=" + chatId +
                '}';
    }
}
