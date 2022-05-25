package org.example.hibernate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    @Column(unique = true)
    @Size(min = 5, max = 20, message = "Username length can`t be less than 5 or more than 20 symbols")
    private String username;
    @NotBlank
    @Size(min = 6, message = "Password length can`t be less than 6 symbols")
    @Size(max = 30, message = "Password length can`t be more than 30 symbols")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<ChatUser> chatUser = new HashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ChatUser> getChatUser() {
        return chatUser;
    }

    public void setChatUser(Set<ChatUser> chatUser) {
        this.chatUser = chatUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
