package com.example.trainogram.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class UserEntity {

    @Id
    private String id;
    private String avatarUrl;
    private String username;
    private String password;
    private String name;

    public UserEntity(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
