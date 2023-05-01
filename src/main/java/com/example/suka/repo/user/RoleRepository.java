package com.example.suka.repo.user;

import com.example.suka.entity.users.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {
    Role findRoleByRoleName(String roleName);
}