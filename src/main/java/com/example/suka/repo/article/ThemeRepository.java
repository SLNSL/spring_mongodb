package com.example.suka.repo.article;

import com.example.suka.entity.articles.Theme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThemeRepository extends MongoRepository<Theme, Integer> {
}