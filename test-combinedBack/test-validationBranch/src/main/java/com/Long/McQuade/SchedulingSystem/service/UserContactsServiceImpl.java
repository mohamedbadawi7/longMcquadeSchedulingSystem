package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.UserContacts;
import com.Long.McQuade.SchedulingSystem.repositories.UserContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContactsServiceImpl implements UserContactsService{

    @Autowired
    private UserContactsRepo repo;


    @Override
    public List<UserContacts> findAll() {
        return repo.findAll();
    }

    @Override
    public UserContacts findBy(int id) {
        return repo.findUserContactById(id);
    }

    @Override
    public UserContacts save(UserContacts userContacts) {
        return repo.save(userContacts);
    }

    @Override
    public List<UserContacts> saveAll(List<UserContacts> userContactsList){
        return repo.saveAll(userContactsList);
    }

    @Override
    public void deleteByID(int id) {
        repo.deleteById(id);
    }

    @Override
    public void deleteByUserNumber(String userNumber) {
        List<UserContacts> userContactList = repo.findAllByUserNumber(userNumber);
        for (UserContacts userContacts : userContactList) {
            int userID = userContacts.getId();
            repo.deleteById(userID);
        }
    }

    @Override
    public void deleteByContactUserNum(String contactUserNum) {
        List<UserContacts> contactList = repo.findAllByContactUserNum(contactUserNum);
        for (UserContacts userContacts : contactList) {
            int userID = userContacts.getId();
            repo.deleteById(userID);
        }
    }

    @Override
    public UserContacts findUserContactById(int id) {
        return repo.findUserContactById(id);
    }

    @Override
    public List<UserContacts> findAllByUserNumber(String userNumber) {
        return repo.findAllByUserNumber(userNumber);
    }

    @Override
    public List<UserContacts> findAllByContactUserNum(String contactUserNum) {
        return repo.findAllByContactUserNum(contactUserNum);
    }

    @Override
    public List<UserContacts> findByUserNumber(String userNumber) {
        return repo.findAllByUserNumber(userNumber);
    }
}

