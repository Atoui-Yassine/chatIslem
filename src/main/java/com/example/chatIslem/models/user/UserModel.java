package com.example.chatIslem.models.user;

import com.example.chatIslem.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserModel extends BaseEntity {


    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    @DBRef
    private Set<Role> roles = new HashSet<>();
    public UserModel(String firstName, String lastName, String username, String email, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email=email;
        this.password = password;

    }

    public UserModel(String email, String password) {

        this.email = email;
        this.password = password;
    }
}
