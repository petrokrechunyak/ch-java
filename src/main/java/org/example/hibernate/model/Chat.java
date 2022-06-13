package org.example.hibernate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chats")
public class Chat {

    public static final int CODE_LENGTH = 10;
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    @Size(min = 3, max = 30, message = "Chat title length can`t be less than 3 or more than 30 symbols")
    private String title;
    @Column(unique = true)
    @Size(min = 10, max = 30, message = "Chat code length can`t be less than 10 or more than 30 symbols")
    private String code;

    @NotNull
    private int members;

    @OneToMany(mappedBy = "chat")
    private Set<ChatUser> chatUser = new HashSet<>();

    @Override
    public String toString() {
        return "Chat{" +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public Set<ChatUser> getChatUser() {
        return chatUser;
    }

    public void setChatUser(Set<ChatUser> chatUser) {
        this.chatUser = chatUser;
    }
}
