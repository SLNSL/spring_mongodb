package com.example.suka.entity.articles;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;


//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "theme")

@Document("theme")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    private int id;

    private String themeName;

}