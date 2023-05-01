package com.example.suka.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.List;

//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "role")

@Document("role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private int id;


    private String roleName;

}