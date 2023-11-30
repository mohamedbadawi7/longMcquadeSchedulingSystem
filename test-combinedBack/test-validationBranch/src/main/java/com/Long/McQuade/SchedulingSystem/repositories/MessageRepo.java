package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.Message;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByRecipientId(Long recipientId);

    @Query("SELECT m FROM Message m WHERE (m.sender.id = :userId AND m.recipient.id = :recipientId) ORDER BY m.time_stamp ASC")
    List<Message> getMessagesForRecipient(@Param("recipientId") Long recipientId, Long userId);

    @Query("SELECT m FROM Message m WHERE (m.sender.id = :recipientId AND m.recipient.id = :userId) ORDER BY m.time_stamp ASC")
    List<Message> getMessagesReceivedFromUser(@Param("recipientId") Long recipientId, Long userId);

    @Query("SELECT m FROM Message m WHERE (m.sender.id = :userId1 AND m.recipient.id = :userId2) OR (m.sender.id = :userId2 AND m.recipient.id = :userId1) ORDER BY m.time_stamp ASC")
    List<Message> findMessagesBetweenUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);

    @Modifying
    @Transactional
    @Query("DELETE FROM Message m WHERE (m.sender.id = :userId1 AND m.recipient.id = :userId2) OR (m.sender.id = :userId2 AND m.recipient.id = :userId1)")
    void deleteMessagesBetweenUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);
}

