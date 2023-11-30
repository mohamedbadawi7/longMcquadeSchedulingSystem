package com.Long.McQuade.SchedulingSystem.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lesson_centre")
public class LessonCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "City cannot be null")
    @Size(min = 4, max = 20)
    @Column(name = "city")
    private String city;

    @Column(name = "phonnum")
    @NotNull(message = "Phone number cannot be empty")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Column(name = "email")
    @NotNull(message = "Email cannot be empty")
    @Size(min = 4, max = 30, message = "Email must be within 4 digits and 30 digits")
    private String email;

    @Column(name = "address")
    @NotNull(message = "Address cannot be empty")
    @Size(min = 4, max = 30, message = "Address must be within 4 digits and 30 characters")
    private String address;

    @Column(name = "postcode")
    @NotNull(message = "Postal Code cannot be empty")
    @Size(min = 7, max = 7, message = "Post code must be 7 digits")
    private String postCode;

    @Column(name = "numofrooms")
    @NotNull(message = "Cannot leave field blank")
    private String numOfRooms;


    public LessonCentre(String city, String phoneNumber, String email, String address, String postCode, String numOfRooms) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.postCode = postCode;
        this.numOfRooms = numOfRooms;
    }

    public LessonCentre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(String numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    @Override
    public String toString() {
        return "LessonCentre{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", numOfRooms='" + numOfRooms + '\'' +
                '}';
    }
}
