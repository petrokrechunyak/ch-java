package org.example.hibernate.DTO;

import org.example.hibernate.model.ChatUser;

import java.time.LocalDateTime;

public class MessageDTO {

    private String text;

    private LocalDateTime dateTime;

    private ChatUser chatUser;

    public MessageDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(ChatUser chatUser) {
        this.chatUser = chatUser;
    }
}

