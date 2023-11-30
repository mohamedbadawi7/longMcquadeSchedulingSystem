package com.Long.McQuade.SchedulingSystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "identifiernumber")
    private String identifierNumber;

    @Column(name = "authority")
    private String authority;

    public Authority(String identifierNumber, String authority) {
        this.identifierNumber = identifierNumber;
        this.authority = authority;
    }


    public Authority() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "identifierNumber='" + identifierNumber + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
