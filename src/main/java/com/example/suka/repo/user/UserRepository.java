package com.example.suka.repo.user;

import com.example.suka.entity.users.Role;
import com.example.suka.entity.users.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    boolean existsByLogin(String login);

    Optional<User> findByLogin(String login);

}