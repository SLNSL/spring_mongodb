package com.example.suka;

import com.example.suka.entity.users.User;
import com.example.suka.repo.article.ArticleRepository;
import com.example.suka.repo.article.ThemeRepository;
import com.example.suka.repo.user.UserPrivilegeRepository;
import com.example.suka.repo.user.UserRepository;
import com.example.suka.repo.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;


//@EnableJpaRepositories(excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ArticleRepository.class),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ThemeRepository.class)},
//        basePackageClasses = {UserPrivilegeRepository.class, UserRepository.class, UserRoleRepository.class}
//)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SukaApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SukaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new User("123", "456"));
        repository.save(new User("abc", "efg"));
    }
}
