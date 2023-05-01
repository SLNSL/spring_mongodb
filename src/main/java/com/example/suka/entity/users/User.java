package com.example.suka.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



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
    private int id;


    private String login;



    private String password;


}