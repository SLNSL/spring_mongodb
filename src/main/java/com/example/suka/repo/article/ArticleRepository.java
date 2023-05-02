package com.example.suka.repo.article;

import com.example.suka.entity.articles.Article;
import com.example.suka.entity.articles.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findById(int id);

    Optional<List<Article>> findAllByHeaderContainingIgnoreCase(String header);

    List<Article> findAllByJournalistName(String name);
}