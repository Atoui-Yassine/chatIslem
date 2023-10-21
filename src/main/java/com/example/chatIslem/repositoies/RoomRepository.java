package com.example.chatIslem.repositoies;

import com.example.chatIslem.models.chat.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room,String> {
    Optional<Room> findBySenderAndRecipient(String sender, String recipient);
    List<Room> findBySender(String sender);
}
