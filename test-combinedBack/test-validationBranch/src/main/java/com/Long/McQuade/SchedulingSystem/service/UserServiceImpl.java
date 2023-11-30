package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Student;
import com.Long.McQuade.SchedulingSystem.entities.User;
import com.Long.McQuade.SchedulingSystem.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findBy(int id) {
        Optional<User> result = repo.findById(id);
        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            throw new RuntimeException("Did not find user with id - " + id);
        }
        return theUser;
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void deleteByID(int id) {

        repo.deleteById(id);
    }

    @Override
    public User findByUserNumber(String userNumber) {
        return repo.findByUserNumber(userNumber);
    }
}
