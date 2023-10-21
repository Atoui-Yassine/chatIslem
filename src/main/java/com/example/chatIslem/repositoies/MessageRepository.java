package com.example.chatIslem.repositoies;

import com.example.chatIslem.models.chat.Message;
import com.example.chatIslem.models.chat.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message,String> {
    long countBySenderAndRecipientAndStatus(
            String sender, String recipient, Status status);

    List<Message> findByChatId(String chatId);
}
