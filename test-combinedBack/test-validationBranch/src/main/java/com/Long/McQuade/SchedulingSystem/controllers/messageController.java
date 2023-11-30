package com.Long.McQuade.SchedulingSystem.controllers;

import com.Long.McQuade.SchedulingSystem.entities.Message;
import com.Long.McQuade.SchedulingSystem.entities.User;
import com.Long.McQuade.SchedulingSystem.service.MessageService;
import com.Long.McQuade.SchedulingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class messageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping(value= "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String identificationNumber = authentication.getName();
        User sender = userService.findByUserNumber(identificationNumber);

        User receiver = userService.findBy(message.getRecipient().getId());

        message.setSender(sender);
        message.setRecipient(receiver);

        Message savedMessage = messageService.saveMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/for/{recipientId}")
    public ResponseEntity<List<Message>> getMessagesForRecipient(@PathVariable("recipientId") Long recipientId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String identificationNumber = authentication.getName();
        User current = userService.findByUserNumber(identificationNumber);
        Long userId = (long) current.getId();
        List<Message> messages = messageService.getMessagesForRecipient(recipientId, userId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/received/{recipientId}")
    public ResponseEntity<List<Message>> getMessagesReceivedByUser(@PathVariable("recipientId") Long recipientId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String identificationNumber = authentication.getName();
        User current = userService.findByUserNumber(identificationNumber);
        Long userId = (long) current.getId();
        List<Message> receivedMessages = messageService.getMessagesReceivedByUser(recipientId, userId);
        return ResponseEntity.ok(receivedMessages);
    }

    @GetMapping("/history/{userId1}/{userId2}")
    public ResponseEntity<List<Message>> findMessagesBetweenUsers(@PathVariable("userId1") Long userId1, @PathVariable("userId2") Long userId2) {
        List<Message> messageHistory = messageService.findMessagesBetweenUsers(userId1, userId2);
        return ResponseEntity.ok(messageHistory);
    }

    @DeleteMapping("/delete/history/{userId1}/{userId2}")
    public ResponseEntity<?> deleteMessagesBetweenUsers(@PathVariable Long userId1, @PathVariable Long userId2) {
        messageService.deleteMessagesBetweenUsers(userId1, userId2);
        return ResponseEntity.ok().build();
    }
}
