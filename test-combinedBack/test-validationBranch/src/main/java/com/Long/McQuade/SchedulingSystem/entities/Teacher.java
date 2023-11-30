package com.Long.McQuade.SchedulingSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "teachernum")
    private String teacherNumber;

    @Column(name = "first")
    @Size(min = 2, max = 20, message = "First name must be between 2 characters and 20 characters")
    private String firstName;

    @Column(name = "last")
    @Size(min = 2, max = 20, message = "Last name must be between 2 characters and 20 characters")
    private String lastName;

    @Column(name = "address")
    @Size(min = 5, max = 30, message = "Address must be between 5 characters and 30 characters")
    private String address;

    @Column(name = "postcode")
    @Size(min = 7, max = 7, message = "Post code must be 7 characters")
    private String postCode;

    @Column(name = "email")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    private String email;

    @Column(name = "instruments")
    @Size(min = 5, max = 50, message = "Instruments must be between 5 and 50 characters")
    private String instrumentsTaught;

    @Column(name = "starttime")
    @Size(min = 5, max = 5, message = "Start time must be 5 characters")
    private String starttime;

    @Column(name = "endtime")
    @Size(min = 5, max = 5, message = "End time must be 5 characters")
    private String endtime;


    public Teacher(String firstName, String lastName, String address, String postCode, String email, String instrumentsTaught, String starttime, String endtime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postCode = postCode;
        this.email = email;
        this.instrumentsTaught = instrumentsTaught;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Teacher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
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

    public String getInstrumentsTaught() {
        return instrumentsTaught;
    }

    public void setInstrumentsTaught(String instrumentsTaught) {
        this.instrumentsTaught = instrumentsTaught;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", email='" + email + '\'' +
                ", instrumentsTaught='" + instrumentsTaught + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }
}
