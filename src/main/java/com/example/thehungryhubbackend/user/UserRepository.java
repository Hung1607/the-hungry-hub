package com.example.thehungryhubbackend.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserByUsername(String username);

    UserEntity findUserByName(String name);
}
