package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Authority;
import com.Long.McQuade.SchedulingSystem.entities.User;
import com.Long.McQuade.SchedulingSystem.repositories.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepo repo;

    @Override
    public List<Authority> findAll() {
        return repo.findAll();
    }

    @Override
    public Authority findBy(int id) {
        Optional<Authority> result = repo.findById(id);
        Authority theAuthority = null;

        if (result.isPresent()) {
            theAuthority = result.get();
        }
        else {
            throw new RuntimeException("Did not find authority with id - " + id);
        }
        return theAuthority;
    }

    @Override
    public Authority save(Authority authority) {
        return repo.save(authority);
    }

    @Override
    public void deleteByID(int id) {

        repo.deleteById(id);
    }

    @Override
    public List<Authority> findByAuthority(String authority) {
        return repo.findByAuthority(authority);
    }

    @Override
    public Authority findByIdentifierNumber(String identifierNumber){
        return repo.findAuthorityByIdentifierNumber(identifierNumber);
    }
}
