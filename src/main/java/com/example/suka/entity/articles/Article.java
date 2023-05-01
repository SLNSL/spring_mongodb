package com.example.suka.entity.articles;

import org.springframework.data.annotation.Id;
import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;




@Document("article")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    @Id
    private int id;


    private String header;


    private String subheader;


    private String text;


    private Integer priority;


    private String photo;

    private String journalistName;
}