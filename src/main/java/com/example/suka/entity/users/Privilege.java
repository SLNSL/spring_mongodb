package com.example.suka.entity.users;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.data.annotation.Id;
import java.util.List;

//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "privilege")

@Document("privilege")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilege implements GrantedAuthority {
    @Id
    private int id;

    private String privilegeName;


    @Override
    public String getAuthority() {
        return privilegeName;
    }
}