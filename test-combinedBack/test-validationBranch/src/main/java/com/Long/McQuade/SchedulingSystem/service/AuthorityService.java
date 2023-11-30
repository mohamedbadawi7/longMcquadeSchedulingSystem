package com.Long.McQuade.SchedulingSystem.service;

import com.Long.McQuade.SchedulingSystem.entities.Authority;
import com.Long.McQuade.SchedulingSystem.entities.User;
import com.Long.McQuade.SchedulingSystem.repositories.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AuthorityService {

    List<Authority> findAll();

    Authority findBy(int id);

    Authority save(Authority authority);

    void deleteByID(int id);

    public List<Authority> findByAuthority(String authority);

    public Authority findByIdentifierNumber(String identifierNumber);

}
