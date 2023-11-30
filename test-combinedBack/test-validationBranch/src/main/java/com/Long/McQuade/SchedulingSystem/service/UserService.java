package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findBy(int id);

    User save(User user);

    void deleteByID(int id);

    public User findByUserNumber(String userNumber);
}
