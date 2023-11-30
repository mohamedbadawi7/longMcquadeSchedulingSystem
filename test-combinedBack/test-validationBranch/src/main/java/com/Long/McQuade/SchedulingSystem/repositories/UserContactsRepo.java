package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.UserContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContactsRepo extends JpaRepository<UserContacts, Integer> {

    public UserContacts findUserContactById(int id);

    public List<UserContacts> findAllByUserNumber(String userNumber);

    public List<UserContacts> findAllByContactUserNum(String contactUserNum);

}
