package com.example.chatIslem.services.user;

import com.example.chatIslem.exceptions.EntityNotFoundException;
import com.example.chatIslem.models.user.UserModel;
import com.example.chatIslem.repositoies.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }


    public void deleteUser(String id) {

    }


    public UserModel getUser(String id) {
        UserModel user=userRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("user Not Found with id : " + id));
        return user;
    }


    public List<UserModel> getAllUser() {

        return userRepository.findAll();
    }
    public List<UserModel> findAllUserEnabled() {
        // Your custom query to find all enabled users
        Query query = new Query(Criteria.where("enabled").is(true));
        return mongoTemplate.find(query, UserModel.class);
    }

    public UserModel getUserByEmail(String email) {
        UserModel user=userRepository.findByEmail(email)
                .orElseThrow(()->new EntityNotFoundException("user Not Found with email : " + email));
        return user;

    }


    public UserModel getUserByUsername(String username) {
        UserModel user=userRepository.findByUsername(username)
                .orElseThrow(()->new EntityNotFoundException("user Not Found with username : " + username));
        return user;

    }


    public Boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public Boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
