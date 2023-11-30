package com.Long.McQuade.SchedulingSystem.entities;


import jakarta.persistence.*;

/**
 * Table for user contacts, column for user number and column for user number that is a contact
 */
@Entity
@Table(name = "user_contacts")
public class UserContacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * user number of user inquiring about
     */
    @Column(name = "identifiernumber")
    private String userNumber;

    /**
     * user number of a contact of the inquired user
     */
    @Column(name = "contact_id_num")
    private String contactUserNum;


    public UserContacts(String userNumber, String contactUserNum) {
        this.userNumber = userNumber;
        this.contactUserNum = contactUserNum;
    }

    public UserContacts() {

    }

    /**
     * Getters and setters for id, userNumber and contactUserNum
     */

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getContactUserNum() {
        return contactUserNum;
    }

    public void setContactUserNum(String contactUserNum) {
        this.contactUserNum = contactUserNum;
    }


    @Override
    public String toString() {
        return "UserContacts{" +
                "id='" + id + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", contactUserNum='" + contactUserNum + '\'' +
                '}';
    }
}
