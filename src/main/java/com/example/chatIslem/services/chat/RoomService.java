package com.example.chatIslem.services.chat;

import com.example.chatIslem.models.chat.Room;
import com.example.chatIslem.repositoies.RoomRepository;
import com.example.chatIslem.utils.kafka.ServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findRoomList(String sender) {
        return roomRepository.findBySender(sender);
    }

    public Optional<String> getChatId(String sender, String recipient, boolean createIfNotExist) {

        Optional<String> existingChat = roomRepository.findBySenderAndRecipient(sender,recipient)
                .map(Room::getChatId);//map Room et extraire  chatId

        if (existingChat.isPresent()) {
            return existingChat;
        }
        if(!createIfNotExist) {
            return  Optional.empty();
        }
        String chatId =
                String.format(ServiceConstants.ROOM_ID_SEPARATOR, sender, recipient);

        Room senderRecipient = Room
                .builder()
                .chatId(chatId)
                .sender(sender)
                .recipient(recipient)
                .build();

        Room recipientSender = Room
                .builder()
                .chatId(chatId)
                .sender(recipient)
                .recipient(sender)
                .build();

        roomRepository.save(senderRecipient);
        roomRepository.save(recipientSender);
        return Optional.of(chatId);
    }

}
