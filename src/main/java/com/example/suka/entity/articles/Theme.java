package com.example.suka.entity.articles;

import com.example.suka.entity.articles.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "theme_name")
    private String themeName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "article_theme",
            joinColumns = {@JoinColumn(name = "theme_id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id")}
    )
    private List<Article> articles;
}