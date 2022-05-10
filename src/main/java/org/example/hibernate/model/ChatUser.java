package org.example.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chats_users", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "user_id", "chat_id" })})
@NoArgsConstructor
@Getter
@Setter
public class ChatUser {

    @Id
    @GeneratedValue
    UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    Chat chat;

    @OneToMany(mappedBy = "chatUser")
    Set<Message> messages;

    public ChatUser(User user, Chat chat) {
        this.user = user;
        this.chat = chat;
    }
}
