package com.Long.McQuade.SchedulingSystem.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/**
 * Message class for messages sent between users
 */
@Entity
@Table(name = "messages")
public class Message {

    //sender of the message
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    //who the message is going to
    @ManyToOne
    @JoinColumn(name="recipient_id")
    private User recipient;

    // the actual message to send
    @Column(name = "msg")
    private String msg;

    //time that the message was sent
    @Column(name = "time_stamp")
    private Timestamp time_stamp;


    public Message() {
    }
    public Message(User recipient, String msg) {
        this.recipient = recipient;
        this.msg = msg;
        this.time_stamp = Timestamp.valueOf(LocalDateTime.now());

    }

    /**
     * Retrieves the unique identifier for the message.
     *
     * @return the unique ID of the message.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the message.
     * This method is typically used by JPA and not directly by application code.
     *
     * @param id the unique ID to set for the message.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get sender
     */
    public User getSender() {
        return sender;
    }

    /**
     * Set sender
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * Get recipient
     */
    public User getRecipient() {
        return recipient;
    }

    /**
     * set recipient
     */
    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    /**
     * Get message
     */
    public String getMsg() {
        return msg;
    }

    /**
     * set message
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Get timestamp
     */
    public Timestamp getTimeStamp() {
        return time_stamp;
    }

    /**
     * set time stamp
     */
    public void setTimestamp(Timestamp timeStamp) {
        this.time_stamp = time_stamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", content='" + msg + '\'' +
                ", timestamp=" + time_stamp +
                '}';
    }
}
