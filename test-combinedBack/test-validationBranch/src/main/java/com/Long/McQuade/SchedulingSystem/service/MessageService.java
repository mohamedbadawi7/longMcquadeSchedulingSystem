package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Message;
import com.Long.McQuade.SchedulingSystem.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesForRecipient(Long recipientId, Long userId) {
        return messageRepository.getMessagesForRecipient(recipientId, userId);
    }

    public List<Message> getMessagesReceivedByUser(Long recipientId, Long userId) {
        return messageRepository.getMessagesReceivedFromUser(recipientId, userId);
    }

    public List<Message> findMessagesBetweenUsers(Long userId1, Long userId2) {
        return messageRepository.findMessagesBetweenUsers(userId1, userId2);
    }

    public void deleteMessagesBetweenUsers(Long userId1, Long userId2) {
        messageRepository.deleteMessagesBetweenUsers(userId1, userId2);
    }

}