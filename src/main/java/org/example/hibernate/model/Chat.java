package org.example.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chats")
@NoArgsConstructor
@Getter
@Setter
public class Chat {
    @Id
    @GeneratedValue
    private UUID id;

    @Size(min = 5, max = 30, message = "Chat title length can`t be less than 5 or more than 30 symbols")
    private String title;

    @Column(unique = true)
    @Size(min = 10, max = 30, message = "Chat code length can`t be less than 10 or more than 30 symbols")
    private String code;

    @OneToMany(mappedBy = "chat")
    private Set<ChatUser> chatUser = new HashSet<>();

    public static final int CODE_LENGTH = 10;

    public Chat(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chat{" +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
