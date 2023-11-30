package com.Long.McQuade.SchedulingSystem.repositories;

import com.Long.McQuade.SchedulingSystem.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {

    public List<Request> findRequestsByIdentificationNumber(String identificationNumber);

    public List<Request> findRequestsByStatus(String status);
}
