package org.example.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    @Size(min = 5, max = 20, message = "Username length can`t be less than 5 or more than 20 symbols")
    private String username;
    @Size(min = 6, message = "password length can`t be less than 6 symbols")
    @Size(max = 30, message = "password length can`t be more than 30 symbols")
    private String password;

    @OneToMany(mappedBy = "user")
    Set<ChatUser> chatUser = new HashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
