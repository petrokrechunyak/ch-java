package org.example.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity(name = "messages")
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "message_text")
    private String text;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "chatUser_id")
    private ChatUser chatUser;

    public Message(String message_text, ChatUser chatUser) {
        dateTime = LocalDateTime.now();
        this.text = message_text;
        this.chatUser = chatUser;
    }
}
