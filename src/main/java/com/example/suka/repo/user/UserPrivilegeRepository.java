package com.example.suka.repo.user;

import com.example.suka.entity.users.Privilege;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends MongoRepository<Privilege, Integer> {
}