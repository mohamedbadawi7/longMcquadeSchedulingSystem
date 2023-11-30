package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.UserContacts;

import java.util.List;

public interface UserContactsService {

    List<UserContacts> findAll();

    UserContacts findBy(int id);

    UserContacts save(UserContacts userContacts);

    List<UserContacts> saveAll(List<UserContacts> userContactsList);

    void deleteByID(int id);

    void deleteByUserNumber(String userNumber);

    void deleteByContactUserNum(String contactUserNum);

    public UserContacts findUserContactById(int id);

    public List<UserContacts> findAllByUserNumber(String userNumber);

    public List<UserContacts> findAllByContactUserNum(String contactUserNum);

    List<UserContacts> findByUserNumber(String userNumber);
}