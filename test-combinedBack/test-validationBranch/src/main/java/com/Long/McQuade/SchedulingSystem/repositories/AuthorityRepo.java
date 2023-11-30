package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Integer> {

    public List<Authority> findByAuthority(String authority);

    public Authority findAuthorityByIdentifierNumber(String identifierNumber);
}
