package com.Long.McQuade.SchedulingSystem.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "snum")
    private String studentNumber;


    @Size(min = 2, max = 20, message = "First name must be between 2 characters and 20 characters")
    @Column(name = "first")
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name must be between 2 characters and 20 characters")
    @Column(name = "last")
    private String lastName;

    @Size(min = 5, max = 30, message = "Address must be between 5 characters and 30 characters")
    @Column(name = "address")
    private String address;

    @Size(min = 7, max = 7, message = "Post code must be 7 characters")
    @Column(name = "pcode")
    private String postCode;


    @Column(name = "email")
    private String email;

    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @Column(name = "played")
    private String instrumentsPlayed;

    @Column(name = "experience")
    private String experience;

    //Removed validation as it is no longer needed
    @Column(name = "yob")
    private LocalDate yearOfBirth;


    public Student(String firstName, String lastName, String address, String postCode, String email, String instrumentsPlayed, String experience, LocalDate yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.instrumentsPlayed = instrumentsPlayed;
        this.experience = experience;
        this.yearOfBirth = yearOfBirth;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstrumentsPlayed() {
        return instrumentsPlayed;
    }

    public void setInstrumentsPlayed(String instrumentsPlayed) {
        this.instrumentsPlayed = instrumentsPlayed;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", email='" + email + '\'' +
                ", instrumentsPlayed='" + instrumentsPlayed + '\'' +
                ", experience='" + experience + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
