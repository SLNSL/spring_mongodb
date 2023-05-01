package com.example.suka.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;


//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Document("my_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private ObjectId id;


    private String login;

    private String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }


}