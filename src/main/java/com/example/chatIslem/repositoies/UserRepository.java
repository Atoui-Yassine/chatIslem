package com.example.chatIslem.repositoies;

import com.example.chatIslem.models.user.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends MongoRepository<UserModel,String> {
    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findByEmail(String email);
    Boolean existsByUsername(String username);
    Optional<UserModel> findById(String id);
    Boolean existsByEmail(String email);


}
