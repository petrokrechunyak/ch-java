package org.example.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Table
@Entity(name = "messages")
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue
    UUID id;

    String message_text;

    LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "chatUser_id")
    ChatUser chatUser;

    public Message(String message_text, ChatUser chatUser) {
        dateTime = LocalDateTime.now();
        this.message_text = message_text;
        this.chatUser = chatUser;
    }
}
